package org.example.sortingvisualizerbackend.model;

public class SortStep {
    private int[] array;
    private int index1;
    private int index2;
    private boolean swapped;
    private boolean sorted;

    public SortStep(int[] array, int index1, int index2, boolean swapped, boolean sorted) {
        this.array = array;
        this.index1 = index1;
        this.index2 = index2;
        this.swapped = swapped;
        this.sorted = sorted;
    }

    public int[] getArray() {return array;}
    public int getIndex1() {return index1;}
    public int getIndex2() {return index2;}
    public boolean isSwapped() {return swapped;}
    public boolean isSorted() {return sorted;}
}
