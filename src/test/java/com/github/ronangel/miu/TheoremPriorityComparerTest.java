package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TheoremPriorityComparerTest {

    @Test
    public void shouldReturnGreaterForShorterTheorem() {
        Theorem shorterTheorem = Theorem.create("MI");
        Theorem longerTheorem = Theorem.create("MIU");

        TheoremPriorityComparer comparer = new TheoremPriorityComparer();

        int val = comparer.compare(shorterTheorem, longerTheorem);

        assertEquals(1, val);
    }

    @Test
    public void shouldReturnLessThenForLongerTheorem() {
        Theorem longerTheorem = Theorem.create("MIU");
        Theorem shorterTheorem = Theorem.create("MI");

        TheoremPriorityComparer comparer = new TheoremPriorityComparer();

        int val = comparer.compare(longerTheorem, shorterTheorem);

        assertEquals(-1, val);
    }

    @Test
    public void shouldReturnEqualsForEqualLengthTheorems() {
        Theorem theoremOne = Theorem.create("MIU");
        Theorem theoremTwo = Theorem.create("MUI");

        TheoremPriorityComparer comparer = new TheoremPriorityComparer();

        int val = comparer.compare(theoremOne, theoremTwo);

        assertEquals(0, val);
    }
}
