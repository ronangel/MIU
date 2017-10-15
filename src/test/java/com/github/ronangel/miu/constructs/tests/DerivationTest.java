package com.github.ronangel.miu.constructs.tests;

import com.github.ronangel.miu.constructs.Derivation;
import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class DerivationTest {

    @Test
    public void shouldContainOnlyMI() {
        Derivation derivation = new Derivation(Theorem.create("MI"));

        Iterator<Theorem> iterator = derivation.iterator();
        Theorem first = iterator.next();

        assertFalse(iterator.hasNext());
        assertEquals(Theorem.create("MI"), first);
    }

    @Test
    public void shouldContainMIAndMIU() {
        Derivation derivation = new Derivation(Theorem.create("MI"));
        derivation = derivation.append(Theorem.create("MIU"));

        Iterator<Theorem> iterator = derivation.iterator();
        Theorem first = iterator.next();
        Theorem second = iterator.next();

        assertFalse(iterator.hasNext());
        assertEquals(Theorem.create("MI"), first);
        assertEquals(Theorem.create("MIU"), second);
    }

    @Test
    public void shouldNotChangeTheoremsInFirstDerivationOnAppend() {
        Derivation derivation = new Derivation(Theorem.create("MI"));
        derivation.append(Theorem.create("MIU"));

        Iterator<Theorem> firstIterator = derivation.iterator();
        Theorem first = firstIterator.next();

        assertFalse(firstIterator.hasNext());
        assertEquals(Theorem.create("MI"), first);
    }

    @Test
    public void shouldBeEqual() {
        Derivation d1 = new Derivation(Theorem.Axioms.MI);
        d1 = d1.append(Theorem.create("MIU"));

        Derivation d2 = new Derivation(Theorem.Axioms.MI);
        d2 = d2.append(Theorem.create("MIU"));

        assertTrue(d1.equals(d2));
    }

    @Test
    public void shouldNotBeEqual() {
        Derivation d1 = new Derivation(Theorem.Axioms.MI);
        d1 = d1.append(Theorem.create("MIU"));

        Derivation d2 = new Derivation(Theorem.Axioms.MI);
        d2 = d2.append(Theorem.create("MII"));

        assertFalse(d1.equals(d2));
    }

    @Test
    public void shouldGenerateUsefulToStringOne() {
        Derivation derivation = new Derivation(Theorem.create("MI"));
        String toString = derivation.toString();
        String expected = "MI";

        assertEquals(expected, toString);
    }

    @Test
    public void shouldGenerateUsefulToStringTwo() {
        Derivation derivation = new Derivation(Theorem.create("MI")).
                                        append(Theorem.create("MIU"));

        String toString = derivation.toString();
        String expected = "MI\n" +
                          "MI -> MIU";

        assertEquals(expected, toString);
    }

    @Test
    public void shouldGenerateUsefulToStringThree() {
        Derivation derivation = new Derivation(Theorem.create("MI")).
                                        append(Theorem.create("MIU")).
                                        append(Theorem.create("MIUIU"));

        String toString = derivation.toString();
        String expected = "MI\n" +
                          "MI -> MIU\n" +
                          "MIU -> MIUIU";

        assertEquals(expected, toString);
    }
}