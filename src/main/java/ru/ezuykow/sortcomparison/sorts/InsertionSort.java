package ru.ezuykow.sortcomparison.sorts;

public class InsertionSort extends Sort{
    @Override
    public void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            for ( ; (j > 0) && (array[j - 1] > temp); j--) {
                array[j] = array[j - 1];
            }
            array[j] = temp;
        }
    }
}
