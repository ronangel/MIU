package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TheoremCacheTest {

    private TheoremCache theoremCache = new TheoremCache();

    @Test
    public void shouldReturnTheoremNotPresent() {
        Theorem theorem = Theorem.create("MI");
        boolean present = theoremCache.put(theorem);

        assertFalse(present);
    }

    @Test
    public void shouldReturnTheremIsPresent() {
        Theorem theorem = Theorem.create("MI");
        theoremCache.put(theorem);
        boolean present = theoremCache.put(theorem);

        assertTrue(present);
    }
}
