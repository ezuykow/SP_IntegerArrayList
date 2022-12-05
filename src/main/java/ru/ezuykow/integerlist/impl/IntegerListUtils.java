package ru.ezuykow.integerlist.impl;

import ru.ezuykow.exceptions.IndexIsNotValidException;
import ru.ezuykow.exceptions.ItemIsNullException;
import ru.ezuykow.sortcomparison.sorts.InsertionSort;

import java.util.Arrays;

public class IntegerListUtils {

    public final static int DEFAULT_ARRAY_SIZE = 10;
    public final static float EXTENSION_FACTOR = 1.5F;

    public static Integer[] extendArray(Integer[] array) {
        final int oldSize = array.length;
        final int newSize = (int) (oldSize * EXTENSION_FACTOR);
        return Arrays.copyOf(array, newSize);
    }

    public static void checkItemIsNotNull(Integer item) {
        if (item == null) {
            throw new ItemIsNullException();
        }
    }

    public static void checkIndexInValidRange(int index, int itemsCount) {
        final int lastIndex = itemsCount - 1;
        if (index < 0 || index > lastIndex) {
            throw new IndexIsNotValidException();
        }
    }

    public static Integer[] insertItem(Integer item, int index, Integer[] items, int itemsCount) {
        Integer[] newArray = new Integer[items.length];
        System.arraycopy(items, 0, newArray, 0, index);
        newArray[index] = item;
        System.arraycopy(items, index, newArray, index + 1, itemsCount - index);
        return newArray;
    }

    public static Integer[] removeItem(int index, Integer[] items, int itemsCount) {
        Integer[] newArray = new Integer[items.length];
        System.arraycopy(items, 0, newArray, 0, index);
        System.arraycopy(items, index + 1, newArray, index, itemsCount - index - 1);
        return newArray;
    }

    public static void sortItems(Integer[] items, int itemsCount) {
        quickSort(items, 0, itemsCount-1);
    }

    private static void quickSort(Integer[] items, int left, int right) {
        if (left < right) {
            int pivot = partition(items, left, right);
            quickSort(items, left, pivot - 1);
            quickSort(items, pivot + 1, right);
        }
    }

    private static int partition(Integer[] items, int left, int right) {
        int i = left - 1;
        for (int j = left; j < right ; j++) {
            if (items[j] <= items[right]) {
                i++;
                swapItems(items, i, j);
            }
        }
        swapItems(items, i + 1, right);
        return i + 1;
    }

    private static void swapItems(Integer[] arr, int idxA, int idxB) {
        int temp = arr[idxA];
        arr[idxA] = arr[idxB];
        arr[idxB] = temp;
    }
}
