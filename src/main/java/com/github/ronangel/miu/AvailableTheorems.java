package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AvailableTheorems {

    private final PriorityQueue<Theorem> theoremQueue;

    public AvailableTheorems(Comparator<Theorem> theoremComparator) {
        theoremQueue = new PriorityQueue<>(theoremComparator.reversed());
    }

    public void add(Theorem theorem) {
        theoremQueue.add(theorem);
    }

    public Theorem next() {
        return theoremQueue.poll();
    }

    public int size() {
        return theoremQueue.size();
    }
}
