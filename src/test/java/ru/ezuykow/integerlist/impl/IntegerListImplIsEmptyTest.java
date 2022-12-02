package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerListImplIsEmptyTest {

    private IntegerList out;

    @BeforeEach
    public void setUp() {
        out = new IntegerListImpl();
    }

    @Test
    public void shouldReturnTrue() {
        assertTrue(out.isEmpty());
    }

    @Test
    public void shouldReturnFalse() {
        out.add(1);
        assertFalse(out.isEmpty());
    }

}