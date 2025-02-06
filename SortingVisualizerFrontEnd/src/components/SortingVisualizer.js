import React, { useState, useEffect } from "react";
import "../App.css";

const SortingVisualizer = () => {
  const [array, setArray] = useState([]);
  const [comparingIndices, setComparingIndices] = useState([]);
  const [swappedIndices, setSwappedIndices] = useState([]);
  const [sortedIndex, setSortedIndex] = useState([]);
  const [arraySize, setArraySize] = useState(100);
  const [speed, setSpeed] = useState(50);
  const [isSorting, setIsSorting] = useState(false);

  // Generate a new random array and reset states
  const generateNewArray = (size = arraySize) => {
    const newArray = Array.from({ length: size }, () => Math.floor(Math.random() * 350) + 1);
    setArray(newArray);
    setComparingIndices([]);
    setSwappedIndices([]);
    setSortedIndex([]);
  };

  // Calculate dynamic bar width based on array length
  const getBarWidth = () => {
    const maxWidth = 600;
    const barWidth = maxWidth / array.length;
    return barWidth > 1 ? barWidth : 1;
  };

  // Fetch sorting steps from backend and animate sorting
  const handleSort = async (algorithm) => {
    if (!array.length || isSorting) return;
    setIsSorting(true);

    try {
      const response = await fetch("https://main-app-latest-7dkc.onrender.com/api/sortSteps", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ array, algorithm }),
      });

      const data = await response.json();
      let sortedSet = new Set();

      // Animate each step with a delay adjusted by speed and array length
      for (let i = 0; i < data.length; i++) {
        setTimeout(() => {
          setArray(data[i].array);

          const comparing = [data[i].index1, data[i].index2];
          const swapped = data[i].swapped ? [data[i].index1, data[i].index2] : [];
          if (data[i].sorted) {
            sortedSet.add(data[i].index2);
          }
          if (i === data.length-1){
            setIsSorting(false);
          }
          setComparingIndices(comparing);
          setSwappedIndices(swapped);
          setSortedIndex([...sortedSet]);
        }, i * (speed * 10 / array.length));
      }
    } catch (error) {
      console.error("Error fetching sort steps:", error);
      setIsSorting(false);
    }
  };

  // Determine bar color based on current state
  const getBarColor = (index) => {
    if (sortedIndex.includes(index)) return "green";
    if (swappedIndices.includes(index)) return "red";
    if (comparingIndices.includes(index)) return "yellow";
    return "blue";
  };

  useEffect(() => {
    generateNewArray();
  }, [arraySize]);

  return (
    <div className="sorting-visualizer-container">
      <div className="bar-container">
        {array.map((value, index) => (
          <div
            key={index}
            className="bar"
            style={{
              height: `${value}px`,
              width: `${getBarWidth()}px`,
              backgroundColor: getBarColor(index),
            }}
          />
        ))}
      </div>
      <div className="bottomButtons">
        <div className="controls">
          <div className="slider-container">
            <label>Array Size</label>
            <input
              type="range"
              min="10"
              max="350"
              value={arraySize}
              onChange={(e) => setArraySize(Number(e.target.value))}
              disabled={isSorting}
            />
          </div>
          <button onClick={() => generateNewArray()} className="sorting-button" disabled={isSorting}>
            Generate New Array
          </button>
          <div className="slider-container">
            <label>Delay: {speed} ms</label>
            <input
              type="range"
              min="1"
              max="200"
              value={speed}
              onChange={(e) => setSpeed(Number(e.target.value))}
              disabled={isSorting}
            />
          </div>
        </div>
        <div className="sorting-buttons">
          <button
            onClick={() => handleSort("bubble")}
            className="sorting-button"
            disabled={isSorting}
          >
            Bubble Sort
          </button>
          <button
            onClick={() => handleSort("selection")}
            className="sorting-button"
            disabled={isSorting}
          >
            Selection Sort
          </button>
          <button
            onClick={() => handleSort("quick")}
            className="sorting-button"
            disabled={isSorting}
          >
            Quick Sort
          </button>
          <button
            onClick={() => handleSort("merge")}
            disabled={isSorting}
            className="sorting-button"
          >
            Merge Sort
          </button>
        </div>
      </div>
    </div>
  );
};

export default SortingVisualizer;
