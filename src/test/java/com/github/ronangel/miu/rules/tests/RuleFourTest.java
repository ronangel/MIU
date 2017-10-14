package com.github.ronangel.miu.rules.tests;

import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.Rule;
import com.github.ronangel.miu.rules.RuleFour;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RuleFourTest {

    private Rule ruleFour = new RuleFour();

    @Test
    public void shouldReturnZeroTheorems() {
        Theorem theorem = Theorem.create("MI");
        List<Theorem> resultingTheorems = ruleFour.apply(theorem);

        assertEquals(0, resultingTheorems.size());
    }

    @Test
    public void shouldReturnOneTheoremMI() {
        Theorem theorem = Theorem.create("MIUU");
        List<Theorem> resultingTheorems = ruleFour.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("MI"), resultingTheorems.get(0));
    }

    @Test
    public void shouldReturnOneTheoremMI2() {
        Theorem theorem = Theorem.create("MUUI");
        List<Theorem> resultingTheorems = ruleFour.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("MI"), resultingTheorems.get(0));
    }

    @Test
    public void shouldReturnOneTheoremM() {
        Theorem theorem = Theorem.create("MUU");
        List<Theorem> resultingTheorems = ruleFour.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("M"), resultingTheorems.get(0));
    }

    @Test
    public void shouldReturnTwoTheorems() {
        Theorem theorem = Theorem.create("MUUU");
        List<Theorem> resultingTheorems = ruleFour.apply(theorem);

        assertEquals(2, resultingTheorems.size());
        assertEquals(Theorem.create("MU"), resultingTheorems.get(0));
        assertEquals(Theorem.create("MU"), resultingTheorems.get(1));
    }

    @Test
    public void shouldReturnThreeTheorems() {
        Theorem theorem = Theorem.create("MIUUIUUIUUI");
        List<Theorem> resultingTheorems = ruleFour.apply(theorem);

        assertEquals(3, resultingTheorems.size());
        assertEquals(Theorem.create("MIIUUIUUI"), resultingTheorems.get(0));
        assertEquals(Theorem.create("MIUUIIUUI"), resultingTheorems.get(1));
        assertEquals(Theorem.create("MIUUIUUII"), resultingTheorems.get(2));
    }
}
