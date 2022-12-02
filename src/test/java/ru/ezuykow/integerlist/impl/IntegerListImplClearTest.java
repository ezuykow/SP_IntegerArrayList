package ru.ezuykow.integerlist.impl;

import org.junit.jupiter.api.Test;
import ru.ezuykow.integerlist.IntegerList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerListImplClearTest {

    @Test
    public void isEmptyShouldReturnTrueAfterClear() {
        IntegerList out = new IntegerListImpl();
        out.add(1);
        out.clear();
        assertTrue(out.isEmpty());
    }
}