package com.github.ronangel.miu.rules.tests;

import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.Rule;
import com.github.ronangel.miu.rules.RuleTwo;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RuleTwoTest {

    private Rule ruleTwo = new RuleTwo();

    @Test
    public void shouldReturnOneTheoremMII() {
        Theorem theorem = Theorem.Axioms.MI;
        List<Theorem> resultingTheorems = ruleTwo.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("MII"), resultingTheorems.get(0));
    }

    @Test
    public void shouldReturnOneTheoremMIUIU() {
        Theorem theorem = Theorem.create("MIU");
        List<Theorem> resultingTheorems = ruleTwo.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("MIUIU"), resultingTheorems.get(0));
    }
}
