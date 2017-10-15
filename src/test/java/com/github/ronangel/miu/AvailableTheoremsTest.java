package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class AvailableTheoremsTest {

    @Test
    public void shouldReturnNextAvailableIsMI() {
        AvailableTheorems availableTheorems = new AvailableTheorems(new TheoremPriorityComparer());
        availableTheorems.add(Theorem.create("MI"));
        availableTheorems.add(Theorem.create("MII"));
        availableTheorems.add(Theorem.create("MIII"));

        Theorem nextTheorem = availableTheorems.next();

        assertEquals(Theorem.create("MI"), nextTheorem);
    }

    @Test
    public void shouldReturnNextAvailableIsNull() {
        AvailableTheorems availableTheorems = new AvailableTheorems(new TheoremPriorityComparer());
        assertNull(availableTheorems.next());
    }

    @Test
    public void shouldReturnCorrectSizeWhenEmpty() {
        AvailableTheorems availableTheorems = new AvailableTheorems(new TheoremPriorityComparer());

        assertEquals(0, availableTheorems.size());
    }

    @Test
    public void shouldReturnCorrectSizeAfterAddingTheorems() {
        AvailableTheorems availableTheorems = new AvailableTheorems(new TheoremPriorityComparer());

        availableTheorems.add(Theorem.create("MI"));
        availableTheorems.add(Theorem.create("MIU"));

        assertEquals(2, availableTheorems.size());
    }

    @Test
    public void shouldReturnCorrectSizeAfterTakingOneTheorem() {
        AvailableTheorems availableTheorems = new AvailableTheorems(new TheoremPriorityComparer());
        availableTheorems.add(Theorem.create("MI"));
        availableTheorems.add(Theorem.create("MIU"));
        availableTheorems.next();

        assertEquals(1, availableTheorems.size());
    }
}