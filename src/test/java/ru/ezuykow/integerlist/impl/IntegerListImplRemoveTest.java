package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.exceptions.IndexIsNotValidException;
import ru.ezuykow.exceptions.ItemNotExistException;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerListImplRemoveTest {

    private IntegerList out;

    @BeforeEach
    void setUp() {
        out = new IntegerListImpl();

        out.add(1);
        out.add(2);
        out.add(3);
    }

    @Test
    public void shouldReturnRemovedItem() {
        Integer actual = 2;
        Integer expected = out.remove(1);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowIndexIsNotValidExceptionWhenCallRemoveWithBadIndex() {
        assertThrows(IndexIsNotValidException.class,
                () -> out.remove(4));
    }

    @Test
    public void shouldThrowItemNotExistException() {
        assertThrows(IndexIsNotValidException.class,
                () -> out.remove(10));
    }
}