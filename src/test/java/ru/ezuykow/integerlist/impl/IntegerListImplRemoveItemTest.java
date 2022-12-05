package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.exceptions.ItemNotExistException;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplRemoveItemTest {

    private IntegerList out;

    @BeforeEach
    public void setUp() {
        out = new IntegerListImpl();
        out.add(1);
        out.add(2);
        out.add(3);
    }

    @Test
    public void shouldReturnRemovedItem() {
        Integer actual = 2;
        Integer expected = out.removeItem(2);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowItemNotExistException() {
        assertThrows(ItemNotExistException.class,
                () -> out.removeItem(10));
    }
}