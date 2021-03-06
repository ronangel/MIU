package com.github.ronangel.miu.constructs.tests;

import com.github.ronangel.miu.constructs.Derivation;
import com.github.ronangel.miu.constructs.Symbols;
import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.mock;

public class TheoremTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowForNullString() {
        Theorem.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowForTheoremWithInvalidSymbols() {
        Theorem.create("S");
    }

    @Test
    public void shouldReturnStringValueInToString() {
        Theorem theorem = Theorem.create("MI");

        assertEquals("MI", theorem.toString());
    }

    @Test
    public void shouldEndWithSymbol() {
        Theorem theorem = Theorem.create("MI");

        assertEquals(true, theorem.endsWith(Symbols.I));
    }

    @Test
    public void shouldNotEndWithSymbol() {
        Theorem theorem = Theorem.create("MIU");

        assertEquals(false, theorem.endsWith(Symbols.I));
    }

    @Test
    public void shouldBeEqual() {
        Theorem theorem1 = Theorem.create("MIIUUU");
        Theorem theorem2 = Theorem.create("MIIUUU");

        assertEquals(theorem1, theorem2);
    }

    @Test
    public void shouldAppendSymbol() {
        Theorem theorem = Theorem.create("MI");

        theorem = theorem.append(Symbols.U);

        assertEquals(Theorem.create("MIU"), theorem);
    }

    @Test
    public void shouldAppendString() {
        Theorem theorem = Theorem.create("MI");

        theorem = theorem.append("IU");

        assertEquals(Theorem.create("MIIU"), theorem);
    }

    @Test
    public void shouldAppendToExistingDerivationOnAppendString() {
        Theorem theorem = Theorem.create("MI");
        theorem = theorem.append("U");

        Derivation expectedDerivation = new Derivation(Theorem.create("MI")).
                                                append(Theorem.create("MIU"));

        assertEquals(expectedDerivation, theorem.getDerivation());
    }

    @Test
    public void shouldAppendToExistingDerivationOnAppendSymbol() {
        Theorem theorem = Theorem.create("MI");
        theorem = theorem.append(Symbols.U);

        Derivation expectedDerivation = new Derivation(Theorem.create("MI")).
                append(Theorem.create("MIU"));

        assertEquals(expectedDerivation, theorem.getDerivation());
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowWhenAppendingInvalidString() {
        Theorem theorem = Theorem.create("MI");

        theorem.append("invalid");
    }

    @Test
    public void shouldReplace_III_In_MIIIU() {
        Theorem theorem = Theorem.create("MIIIU");
        theorem = theorem.replace("III".length(), "U", 1);

        assertEquals(Theorem.create("MUU"), theorem);
    }

    @Test
    public void shouldReplace_III_In_MIII() {
        Theorem theorem = Theorem.create("MIII");
        theorem = theorem.replace("III".length(), "U", 1);

        assertEquals(Theorem.create("MU"), theorem);
    }

    @Test
    public void shouldReplaceFirst_III_In_MIIII() {
        Theorem theorem = Theorem.create("MIIII");
        theorem = theorem.replace("III".length(), "U", 1);

        assertEquals(Theorem.create("MUI"), theorem);
    }

    @Test
    public void shouldReplaceSecond_III_In_MIIII() {
        Theorem theorem = Theorem.create("MIIII");
        theorem = theorem.replace("III".length(), "U", 2);

        assertEquals(Theorem.create("MIU"), theorem);
    }

    @Test
    public void shouldRemoveUUFromMUUI() {
        Theorem theorem = Theorem.create("MUUI");
        theorem = theorem.replace("UU".length(), "", 1);

        assertEquals(Theorem.create("MI"), theorem);
    }

    @Test
    public void shouldRemoveUUFromMIUU() {
        Theorem theorem = Theorem.create("MIUU");
        theorem = theorem.replace("UU".length(), "", 2);

        assertEquals(Theorem.create("MI"), theorem);
    }

    @Test
    public void shouldAppendToExistingDerivationOnReplace() {
        Theorem theorem = Theorem.create("MIII");
        theorem = theorem.replace("III".length(), "U", 1);

        Derivation expectedDerivation = new Derivation(Theorem.create("MIII")).
                                                append(Theorem.create("MU"));

        assertEquals(expectedDerivation, theorem.getDerivation());
    }

    @Test
    public void shouldBeItsOwnDerivationWhenNoDerivationIsProvided() {
        Theorem theorem = Theorem.create("MI");
        Derivation derivation = theorem.getDerivation();

        Derivation expectedDerivation = new Derivation(Theorem.create("MI"));

        assertEquals(expectedDerivation, derivation);
    }

    @Test
    public void shouldAppendNewTheoremToDerivation() {
        Derivation derivation = new Derivation(Theorem.create("MI"));
        Theorem theorem = Theorem.create("MIU", derivation);

        Derivation expectedDerivation = new Derivation(Theorem.create("MI")).
                                                append(Theorem.create("MIU"));

        assertEquals(expectedDerivation, theorem.getDerivation());
    }
}