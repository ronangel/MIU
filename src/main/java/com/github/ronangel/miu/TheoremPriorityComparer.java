package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.Comparator;

public class TheoremPriorityComparer implements Comparator<Theorem> {

    @Override
    public int compare(Theorem t1, Theorem t2) {
        return Integer.compare(t2.toString().length(), t1.toString().length());
    }
}
