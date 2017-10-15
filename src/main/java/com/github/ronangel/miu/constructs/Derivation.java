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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Derivation that = (Derivation) o;

        return theorems.equals(that.theorems);
    }

    @Override
    public int hashCode() {
        return theorems.hashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<Theorem> iterator = theorems.iterator();

        Theorem prevTheorem = null;
        while (iterator.hasNext()) {
            Theorem nextTheorem = iterator.next();

            if (prevTheorem != null){
                sb.append(prevTheorem).append(" -> ");
            }

            sb.append(nextTheorem);

            if (iterator.hasNext()) {
                sb.append("\n");
            }

            prevTheorem = nextTheorem;
        }

        return sb.toString();
    }
}