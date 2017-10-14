package com.github.ronangel.miu.constructs.tests;

import com.github.ronangel.miu.constructs.Symbols;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SymbolsTest {

    @Test
    public void shouldFindM() {
        Symbols symbol = Symbols.lookup("M");

        assertEquals(Symbols.M, symbol);
    }

    @Test
    public void shouldFindI() {
        Symbols symbol = Symbols.lookup("I");

        assertEquals(Symbols.I, symbol);
    }

    @Test
    public void shouldFindU() {
        Symbols symbols = Symbols.lookup("U");

        assertEquals(Symbols.U, symbols);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowForInvalidString() {
        Symbols.lookup("S");
    }
}
