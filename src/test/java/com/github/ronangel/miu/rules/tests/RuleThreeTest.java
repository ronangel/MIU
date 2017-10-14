package com.github.ronangel.miu.rules.tests;

import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.Rule;
import com.github.ronangel.miu.rules.RuleThree;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class RuleThreeTest {

    private Rule ruleThree = new RuleThree();


    @Test
    public void shouldReturnZeroTheorems() {
        Theorem theorem = Theorem.create("MI");
        Rule ruleThree = new RuleThree();
        List<Theorem> resultingTheorems = ruleThree.apply(theorem);

        assertEquals(0, resultingTheorems.size());
    }

    @Test
    public void shouldReturnOneTheoremMUU() {
        Theorem theorem = Theorem.create("MIIIU");
        List<Theorem> resultingTheorems = ruleThree.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("MUU"), resultingTheorems.get(0));
    }

    @Test
    public void shouldReturnOneTheoremMU() {
        Theorem theorem = Theorem.create("MIII");
        List<Theorem> resultingTheorems = ruleThree.apply(theorem);

        assertEquals(1, resultingTheorems.size());
        assertEquals(Theorem.create("MU"), resultingTheorems.get(0));
    }

    @Test
    public void shouldReturnTwoTheorems() {
        Theorem theorem = Theorem.create("MIIII");
        List<Theorem> resultingTheorems = ruleThree.apply(theorem);

        assertEquals(2, resultingTheorems.size());
        assertEquals(Theorem.create("MUI"), resultingTheorems.get(0));
        assertEquals(Theorem.create("MIU"), resultingTheorems.get(1));
    }

    @Test
    public void shouldReturnThreeTheorems() {
        Theorem theorem = Theorem.create("MIIIII");
        List<Theorem> resultingTheorems = ruleThree.apply(theorem);

        assertEquals(3, resultingTheorems.size());
        assertEquals(Theorem.create("MUII"), resultingTheorems.get(0));
        assertEquals(Theorem.create("MIUI"), resultingTheorems.get(1));
        assertEquals(Theorem.create("MIIU"), resultingTheorems.get(2));
    }

    @Test
    public void shouldReturnTwoTheoremsFromMIIIUIIIU() {
        Theorem theorem = Theorem.create("MIIIUIIIU");
        List<Theorem> resultingTheorems = ruleThree.apply(theorem);

        assertEquals(2, resultingTheorems.size());
        assertEquals(Theorem.create("MUUIIIU"), resultingTheorems.get(0));
        assertEquals(Theorem.create("MIIIUUU"), resultingTheorems.get(1));
    }
}
