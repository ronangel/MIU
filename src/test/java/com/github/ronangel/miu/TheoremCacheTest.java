package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TheoremCacheTest {

    private TheoremCache theoremCache = new TheoremCache();

    @Test
    public void shouldReturnTheoremIsNew() {
        Theorem theorem = Theorem.create("MI");
        boolean isNew = theoremCache.put(theorem);

        assertTrue(isNew);
    }

    @Test
    public void shouldReturnTheremIsNotNew() {
        Theorem theorem = Theorem.create("MI");
        theoremCache.put(theorem);
        boolean isNew = theoremCache.put(theorem);

        assertFalse(isNew);
    }

}
