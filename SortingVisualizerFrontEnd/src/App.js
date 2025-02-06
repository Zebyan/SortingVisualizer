import React, { useState } from "react";
import SortingVisualizer from "./components/SortingVisualizer";
import './App.css';



const App = () => {
  const [array, setArray] = useState([]);

  return (
    <div className="space">
      <h1>Sorting Visualizer</h1>
      <SortingVisualizer array={array} />
    </div>
  );
};

export default App;
