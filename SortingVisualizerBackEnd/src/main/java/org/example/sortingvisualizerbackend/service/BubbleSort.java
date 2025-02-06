package org.example.sortingvisualizerbackend.service;

import org.example.sortingvisualizerbackend.model.SortStep;
import java.util.List;
import java.util.ArrayList;

public class BubbleSort implements SortingAlgorithmInterface {
    @Override
    public List<SortStep> sort (int[] array){
        List<SortStep> sortSteps = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                sortSteps.add(new SortStep(array.clone(), j, j+1, false,false));
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sortSteps.add(new SortStep(array.clone(), j, j+1, true,false));
                }
            }
            sortSteps.add(new SortStep(array.clone(), 0, n-i-1, false,true));
        }
        sortSteps.add(new SortStep(array.clone(), 0, 0, false,true));
        return sortSteps;
    }
}
