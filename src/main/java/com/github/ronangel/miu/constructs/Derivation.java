package com.github.ronangel.miu.constructs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Derivation implements Iterable<Theorem> {

    private List<Theorem> theorems;

    public Derivation() {
        theorems = new ArrayList<>();
    }

    public Derivation(Theorem axiom) {
        this();

        theorems.add(axiom);
    }

    private Derivation(List<Theorem> startingPoint) {
        this();

        theorems = new ArrayList<>(startingPoint);
    }

    public Derivation append(Theorem theorem) {
        Derivation other = new Derivation(theorems);
        other.theorems.add(theorem);
        return other;
    }

    @Override
    public Iterator<Theorem> iterator() {
        return theorems.iterator();
    }
}