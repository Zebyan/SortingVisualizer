package org.example.sortingvisualizerbackend.service;

import java.util.HashMap;
import java.util.Map;
public class SortingFactory {
    private static final Map<String, SortingAlgorithmInterface> sortingAlgorithms = new HashMap<>();

    static {
        sortingAlgorithms.put("bubble", new BubbleSort());
        sortingAlgorithms.put("selection", new SelectionSort());
        sortingAlgorithms.put("quick", new QuickSort());
        sortingAlgorithms.put("merge", new MergeSort());
    }
    public static SortingAlgorithmInterface getAlgorithm(String name){
        return sortingAlgorithms.getOrDefault(name, null);
    }

}
