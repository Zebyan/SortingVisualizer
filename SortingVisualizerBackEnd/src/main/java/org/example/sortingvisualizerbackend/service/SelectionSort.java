package org.example.sortingvisualizerbackend.service;
import org.example.sortingvisualizerbackend.model.SortStep;
import java.util.ArrayList;
import java.util.List;

public class SelectionSort implements SortingAlgorithmInterface {
    @Override
    public List<SortStep> sort(int[] array) {
        List<SortStep> steps = new ArrayList<>();
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                steps.add(new SortStep(array.clone(), minIndex, j, false,false)); // Comparing

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // Swap elements
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

                steps.add(new SortStep(array.clone(), i, minIndex, true,false)); // Swapped
            }
            steps.add(new SortStep(array.clone(), i, i, false,true));
        }
        steps.add(new SortStep(array.clone(), n-1, n-1, false,true));

        return steps;
    }
}
