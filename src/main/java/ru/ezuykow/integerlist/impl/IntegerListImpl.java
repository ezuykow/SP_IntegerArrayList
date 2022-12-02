package ru.ezuykow.integerlist.impl;

import ru.ezuykow.exceptions.ItemNotExistException;
import ru.ezuykow.exceptions.NullIntegerListException;
import ru.ezuykow.integerlist.IntegerList;

import java.util.Arrays;

import static ru.ezuykow.integerlist.impl.IntegerListUtils.*;

public class IntegerListImpl implements IntegerList {

    private Integer[] items;
    private int arraySize;
    private int itemsCount;

    public IntegerListImpl() {
        this(DEFAULT_ARRAY_SIZE);
    }

    public IntegerListImpl(int initialSize) {
        items = new Integer[initialSize];
        arraySize = initialSize;
    }

    @Override
    public Integer add(Integer item) {
        extendArrayIfNeeded();
        checkItemIsNotNull(item);
        items[itemsCount] = item;
        return items[itemsCount++];
    }

    @Override
    public Integer add(int index, Integer item) {
        if (index == itemsCount) {
            return add(item);
        }
        checkIndexInValidRange(index, itemsCount);
        checkItemIsNotNull(item);
        extendArrayIfNeeded();
        items = insertItem(item, index, items, itemsCount++);
        return items[index];
    }

    @Override
    public Integer set(int index, Integer item) {
        checkIndexInValidRange(index, itemsCount);
        checkItemIsNotNull(item);
        items[index] = item;
        return items[index];
    }

    @Override
    public Integer remove(int index) {
        checkIndexInValidRange(index, itemsCount);
        Integer removedItem = items[index];
        if (index == itemsCount - 1) {
            items[index] = null;
        } else {
            items = IntegerListUtils.removeItem(index, items, itemsCount);
        }
        itemsCount--;
        return removedItem;
    }

    @Override
    public Integer removeItem(Integer item) {
        int index = indexOf(item);
        if (index < 0) {
            throw new ItemNotExistException();
        }
        return remove(index);
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) > -1;
    }

    @Override
    public int indexOf(Integer item) {
        sortItems(items, itemsCount);
        int idxCurrent = Arrays.binarySearch(Arrays.copyOf(items, itemsCount), item);

        while ((idxCurrent > 0) && (items[idxCurrent - 1].equals(item))) {
            idxCurrent--;
        }

        return idxCurrent;
    }

    @Override
    public int lastIndexOf(Integer item) {
        sortItems(items, itemsCount);
        int idxCurrent = Arrays.binarySearch(Arrays.copyOf(items, itemsCount), item);

        while ((idxCurrent > 0) && (idxCurrent < itemsCount - 1) && (items[idxCurrent + 1].equals(item))) {
            idxCurrent++;
        }

        return idxCurrent;
    }

    @Override
    public Integer get(int index) {
        checkIndexInValidRange(index, itemsCount);
        return items[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            throw new NullIntegerListException();
        }
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(items, itemsCount);
    }

    @Override
    public int size() {
        return itemsCount;
    }

    @Override
    public boolean isEmpty() {
        return itemsCount == 0;
    }

    @Override
    public void clear() {
        Arrays.fill(items, null);
        itemsCount = 0;
    }

    private void extendArrayIfNeeded() {
        if (itemsCount == arraySize) {
            items = extendArray(items);
            arraySize = items.length;
        }
    }
}
