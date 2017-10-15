package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.HashSet;
import java.util.Set;

public class TheoremCache {

    private Set<Theorem> cache = new HashSet<>();

    public boolean put(Theorem theorem) {
        return cache.add(theorem);
    }
}
