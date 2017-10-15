package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Derivation;
import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.Rule;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MiuSolver {

    private final AvailableTheorems availableTheorems;
    private final TheoremCache theoremCache;
    private Theorem objective;
    private final List<Rule> rules;
    private int maxSteps;

    public MiuSolver() {
        Comparator<Theorem> strategy = new TheoremPriorityComparer();
        availableTheorems = new AvailableTheorems(strategy);
        theoremCache = new TheoremCache();
        rules = new ArrayList<>();
        maxSteps = 200;
    }

    public void addAxiom(Theorem axiom) {
        theoremCache.put(axiom);
        availableTheorems.add(axiom);
    }

    public void setObjective(Theorem theorem) {
        objective = theorem;
    }

    public Derivation solve() throws SolutionTimeoutException {
        validatePreState();

        Theorem next;
        int stepNum = 0;

        while (availableTheorems.size() > 0 && ++stepNum <= maxSteps) {

            next = availableTheorems.next();

            for (Rule rule : rules) {
                List<Theorem> resultingTheorems = rule.apply(next);

                for (Theorem theorem : resultingTheorems) {
                    if (theorem.equals(objective)) {
                        return theorem.getDerivation();
                    }

                    boolean isNew = theoremCache.put(theorem);

                    if (isNew) {
                        availableTheorems.add(theorem);
                    }
                }
            }
        }

        throw new SolutionTimeoutException();
    }

    private void validatePreState() {
        if (availableTheorems.size() == 0) {
            throw new IllegalStateException("no axioms provided");
        }

        if (objective == null) {
            throw new IllegalStateException("no objective set");
        }

        if (rules.size() == 0) {
            throw new IllegalStateException("no rules provided");
        }

    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public void setSolutionStepLimit(int maxSteps) {
        this.maxSteps = maxSteps;
    }
}
