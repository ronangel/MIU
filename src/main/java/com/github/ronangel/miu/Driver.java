package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Derivation;
import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.RuleFour;
import com.github.ronangel.miu.rules.RuleOne;
import com.github.ronangel.miu.rules.RuleThree;
import com.github.ronangel.miu.rules.RuleTwo;

public class Driver {

    public static void main(String[] args) {
        MiuSolver solver = new MiuSolver();
        solver.addAxiom(Theorem.Axioms.MI);
        solver.addRule(new RuleOne());
        solver.addRule(new RuleTwo());
        solver.addRule(new RuleThree());
        solver.addRule(new RuleFour());
        solver.setSolutionStepLimit(1000000);

        solver.setObjective(Theorem.create("MU"));

        try
        {
            Derivation solution = solver.solve();

            System.out.println(solution);
        } catch (SolutionTimeoutException timeoutException) {
            System.out.println("No solution was found!");
        }
    }
}
