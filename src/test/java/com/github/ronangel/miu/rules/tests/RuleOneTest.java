package com.github.ronangel.miu.rules.tests;

import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.Rule;
import com.github.ronangel.miu.rules.RuleOne;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RuleOneTest {

    @Test
    public void shouldReturnOneTheoremMIU() {
        Rule ruleOne = new RuleOne();
        Theorem axiom = Theorem.Axioms.MI;
        List<Theorem> resultingTheorems = ruleOne.apply(axiom);

        assertEquals(1, resultingTheorems.size());
        assertEquals("MIU", resultingTheorems.get(0).toString());
    }

    @Test
    public void shouldNotReturnNewTheorems() {
        Rule ruleOne = new RuleOne();
        Theorem theorem = Theorem.create("MIU");
        List<Theorem> resultingTheorems = ruleOne.apply(theorem);

        assertEquals(0, resultingTheorems.size());
    }
}