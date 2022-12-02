package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerListImplLastIndexOfTest {

    private IntegerList out;

    @BeforeEach
    void setUp() {
        out = new IntegerListImpl();

        out.add(1);
        out.add(2);
        out.add(3);
        out.add(3);

    }

    @Test
    public void shouldReturnIndexOfItem() {
        int actual = 3;
        int expected = out.lastIndexOf(3);
        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnBadIndexIfItemNotExist() {
        assertTrue(out.lastIndexOf(10) < 0);
    }
}