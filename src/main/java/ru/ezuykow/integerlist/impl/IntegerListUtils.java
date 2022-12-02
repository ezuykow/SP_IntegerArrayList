package ru.ezuykow.integerlist.impl;

import ru.ezuykow.exceptions.IndexIsNotValidException;
import ru.ezuykow.exceptions.ItemIsNullException;
import ru.ezuykow.sortcomparison.sorts.InsertionSort;

import java.util.Arrays;

public class IntegerListUtils {

    public final static int DEFAULT_ARRAY_SIZE = 10;
    public final static int EXTENSION_FACTOR = 2;

    public static Integer[] extendArray(Integer[] array) {
        final int oldSize = array.length;
        final int newSize = oldSize * EXTENSION_FACTOR;
        return array = Arrays.copyOf(array, newSize);
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
        insertionSort(items, itemsCount);
    }

    private static void insertionSort(Integer[] items, int itemsCount) {
        for (int i = 1; i < itemsCount; i++) {
            int temp = items[i];
            int j = i;
            for ( ; (j > 0) && (items[j - 1] > temp); j--) {
                items[j] = items[j - 1];
            }
            items[j] = temp;
        }
    }
}
