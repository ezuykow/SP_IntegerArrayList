package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.exceptions.IndexIsNotValidException;
import ru.ezuykow.exceptions.ItemIsNullException;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerListImplAddTest {

    private IntegerList defaultEmptyList;
    private IntegerList defaultListWithThreeItems;
    private IntegerList fullListWithThreeItems;

    @BeforeEach
    void setUp() {
        defaultEmptyList = new IntegerListImpl();
        defaultListWithThreeItems = new IntegerListImpl();
        fullListWithThreeItems = new IntegerListImpl(3);

        defaultListWithThreeItems.add(3);
        defaultListWithThreeItems.add(2);
        defaultListWithThreeItems.add(1);

        fullListWithThreeItems.add(3);
        fullListWithThreeItems.add(2);
        fullListWithThreeItems.add(1);
    }

    @Test
    public void shouldReturnAddedItem() {
        Integer actual = 5;
        Integer expected =  defaultEmptyList.add(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAddedItemWhenExpendArray() {
        Integer actual = 5;
        Integer expected = fullListWithThreeItems.add(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowItemIsNullExceptionWhenArgumentIsNull() {
        assertThrows(ItemIsNullException.class,
                () -> defaultEmptyList.add(null));
    }

    @Test
    public void shouldReturnAddedByIndexItem() {
        Integer actual = 5;
        Integer expected = defaultListWithThreeItems.add(1, actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIndexIsNotValidException() {
        assertThrows(IndexIsNotValidException.class,
                () -> defaultListWithThreeItems.add(-1, 10));
        assertThrows(IndexIsNotValidException.class,
                () -> defaultListWithThreeItems.add(4, 10));
    }

    @Test
    public void shouldReturnAddedItemWhenIndexMoreWhenSizeOfArray() {
        Integer actual = 5;
        Integer expected = fullListWithThreeItems.add(3, actual);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowItemIsNullExceptionWhenTryToAddNullByIndex() {
        assertThrows(ItemIsNullException.class,
                () -> defaultListWithThreeItems.add(1, null));
    }

}