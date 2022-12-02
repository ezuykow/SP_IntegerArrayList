package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.exceptions.NullIntegerListException;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListImplEqualsTest {

    private IntegerList out;
    private IntegerList otherList;

    @BeforeEach
    public void setUp() {
        out = new IntegerListImpl(3);
        out.add(1);
        out.add(2);
        out.add(3);

        otherList = new IntegerListImpl();
        otherList.add(1);
        otherList.add(2);
        otherList.add(3);
    }

    @Test
    public void shouldReturnTrue() {
        assertTrue(out.equals(otherList));
    }

    @Test
    public void shouldReturnFalse() {
        otherList.add(4);
        assertFalse(out.equals(otherList));
    }

    @Test
    public void shouldThrowNullStringListException() {
        assertThrows(NullIntegerListException.class,
                () -> out.equals(null));
    }
}