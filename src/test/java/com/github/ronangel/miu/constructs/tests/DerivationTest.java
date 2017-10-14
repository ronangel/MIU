package com.github.ronangel.miu.constructs.tests;

import com.github.ronangel.miu.constructs.Derivation;
import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;

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
}