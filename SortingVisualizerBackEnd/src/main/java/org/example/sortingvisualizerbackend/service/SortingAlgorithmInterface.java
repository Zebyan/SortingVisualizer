package org.example.sortingvisualizerbackend.service;

import org.example.sortingvisualizerbackend.model.SortStep;

import java.util.List;

public interface SortingAlgorithmInterface {
    List<SortStep> sort (int[] array) ;
}
