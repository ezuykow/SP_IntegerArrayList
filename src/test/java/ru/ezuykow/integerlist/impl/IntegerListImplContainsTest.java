package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerListImplContainsTest {

    private IntegerList out;

    @BeforeEach
    public void setUp() {
        out = new IntegerListImpl();
        out.add(1);
    }


    @Test
    public void shouldReturnTrueWhenItemContains() {
        assertTrue(out.contains(1));
    }

    @Test
    public void shouldReturnFalseThenItemNotContains() {
        assertFalse(out.contains(10));
    }
}