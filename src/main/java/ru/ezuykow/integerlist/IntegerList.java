package ru.ezuykow.integerlist;

public interface IntegerList {

    Integer add(Integer item);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer remove(int index);

    Integer removeItem(Integer item);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);

    boolean equals(IntegerList otherList);

    Integer[] toArray();

    int size();

    boolean isEmpty();

    void clear();
}
