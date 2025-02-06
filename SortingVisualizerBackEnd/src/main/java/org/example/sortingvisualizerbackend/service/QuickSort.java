package org.example.sortingvisualizerbackend.service;

import org.example.sortingvisualizerbackend.model.*;
import java.util.ArrayList;
import java.util.List;

public class QuickSort implements SortingAlgorithmInterface {

    private List<SortStep> steps;

    @Override
    public List<SortStep> sort(int[] array) {
        steps = new ArrayList<>();
        quickSort(array, 0, array.length - 1);
        // Add a final step that marks the entire array as sorted.
        steps.add(new SortStep(array.clone(), 0, array.length - 1, false, true));
        return steps;
    }

    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            steps.add(new SortStep(arr.clone(), low, high, false, false));
            int pivotIndex = partition(arr, low, high);
            steps.add(new SortStep(arr.clone(), pivotIndex, pivotIndex, false, true));
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        } else if (low == high) {
            // Base case: a single element is already sorted.
            steps.add(new SortStep(arr.clone(), low, low, false, true));
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        steps.add(new SortStep(arr.clone(), low, high, false, false));

        for (int j = low; j < high; j++) {
            steps.add(new SortStep(arr.clone(), j, high, false, false));
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
                steps.add(new SortStep(arr.clone(), i, j, true, false));
            }
        }
        swap(arr, i + 1, high);
        steps.add(new SortStep(arr.clone(), i + 1, high, true, true));
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}


