package ru.ezuykow.sortcomparison.sorts;

public abstract class Sort {

    public abstract void sort(int[] array);

    protected static void swapElements(int[] array, int idxA, int idxB) {
        array[idxA] += array[idxB];
        array[idxB] = array[idxA] - array[idxB];
        array[idxA] -= array[idxB];
    }
}
