package org.example.sortingvisualizerbackend.service;

import org.example.sortingvisualizerbackend.model.SortStep;
import java.util.ArrayList;
import java.util.List;

public class MergeSort implements SortingAlgorithmInterface {
    private List<SortStep> steps;

    @Override
    public List<SortStep> sort(int[] array) {
        steps = new ArrayList<>();
        mergeSortHelper(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            steps.add(new SortStep(array.clone(), i, i, false, true));
        }
        return steps;
    }

    private void mergeSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortHelper(arr, left, mid);
            mergeSortHelper(arr, mid + 1, right);
            merge(arr, left, mid, right);
        } else if (left == right) {
            // Single element is inherently sorted
            steps.add(new SortStep(arr.clone(), left, left, false, true));
        }
    }

    private void merge(int[] arr, int left, int mid, int right, List<SortStep> steps) {

        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {

            steps.add(new SortStep(arr.clone(), left + i, mid + 1 + j, false, false));
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            steps.add(new SortStep(arr.clone(), k, k, true, false));
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            steps.add(new SortStep(arr.clone(), k, k, true, false));
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            steps.add(new SortStep(arr.clone(), k, k, true, false));
            j++;
            k++;
        }

        for (int x = left; x <= right; x++) {
            steps.add(new SortStep(arr.clone(), x, x, false, true));
        }
    }


    private void merge(int[] arr, int left, int mid, int right) {
        merge(arr, left, mid, right, steps);
    }
}

