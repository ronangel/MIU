package com.github.ronangel.miu;

import com.github.ronangel.miu.constructs.Derivation;
import com.github.ronangel.miu.constructs.Theorem;
import com.github.ronangel.miu.rules.RuleFour;
import com.github.ronangel.miu.rules.RuleOne;
import com.github.ronangel.miu.rules.RuleThree;
import com.github.ronangel.miu.rules.RuleTwo;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import static junit.framework.TestCase.assertEquals;

public class MiuSolverTest {

    private MiuSolver solver;

    @Before
    public void setup() {
        solver = new MiuSolver();
        solver.addAxiom(Theorem.Axioms.MI);
        solver.addRule(new RuleOne());
        solver.addRule(new RuleTwo());
        solver.addRule(new RuleThree());
        solver.addRule(new RuleFour());
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIfNoAxiomsSet() throws Exception {
        MiuSolver solver = new MiuSolver();
        solver.setObjective(Theorem.create("MI"));

        solver.solve();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIfNoObjectiveSet() throws Exception {
        MiuSolver solver = new MiuSolver();
        solver.addAxiom(Theorem.Axioms.MI);

        solver.solve();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIfNoRules() throws Exception {
        MiuSolver solver = new MiuSolver();
        solver.setObjective(Theorem.create("MI"));
        solver.addAxiom(Theorem.Axioms.MI);

        solver.solve();
    }

    @Test
    public void shouldSolveForMI() throws Exception {
        solver.setObjective(Theorem.create("MI"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI).
                                      append(Theorem.create("MII")).
                                      append(Theorem.create("MIIII")).
                                      append(Theorem.create("MIIIIU")).
                                      append(Theorem.create("MIUU")).
                                      append(Theorem.create("MI"));

        assertEquals(expected, solution);
    }

    @Test
    public void shouldSolveForMIU() throws Exception {
        solver.setObjective(Theorem.create("MIU"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI)
                                     .append(Theorem.create("MIU"));

        assertEquals(expected, solution);
    }

    @Test
    public void shouldSolveForMII() throws Exception {
        solver.setObjective(Theorem.create("MII"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI).
                                      append(Theorem.create("MII"));

        assertEquals(expected, solution);
    }

    @Test
    public void shouldSolveForMIUIU() throws Exception {
        solver.setObjective(Theorem.create("MIUIU"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI).
                                      append(Theorem.create("MIU")).
                                      append(Theorem.create("MIUIU"));

        assertEquals(expected, solution);
    }

    @Test
    public void shouldSolveForMUI() throws Exception {
        solver.setObjective(Theorem.create("MUI"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI).
                                      append(Theorem.create("MII")).
                                      append(Theorem.create("MIIII")).
                                      append(Theorem.create("MUI"));

        assertEquals(expected, solution);
    }

    @Test
    public void shouldSolveForMUIU() throws Exception {
        solver.setObjective(Theorem.create("MUIU"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI).
                                      append(Theorem.create("MII")).
                                      append(Theorem.create("MIIII")).
                                      append(Theorem.create("MUI")).
                                      append(Theorem.create("MUIU"));

        assertEquals(expected, solution);
    }

    @Test
    public void shouldSolveForMUIIU() throws Exception {
        solver.setObjective(Theorem.create("MUIIU"));
        Derivation solution = solver.solve();
        Derivation expected = new Derivation(Theorem.Axioms.MI).
                                      append(Theorem.create("MII")).
                                      append(Theorem.create("MIIII")).
                                      append(Theorem.create("MUI")).
                                      append(Theorem.create("MUIU")).
                                      append(Theorem.create("MUIUUIU")).
                                      append(Theorem.create("MUIIU"));

        assertEquals(expected, solution);
    }

    @Test(expected = SolutionTimeoutException.class, timeout = 1000L)
    public void shouldTimeOutForImpossibleObjective() throws Exception {
        solver.setObjective(Theorem.create("U"));
        solver.setSolutionStepLimit(1000);
        solver.solve();
    }

    @Test(expected = SolutionTimeoutException.class, timeout = 1000L)
    public void shouldTimeoutForImpossibleObjectiveFromDefaultTimeout() throws Exception {
        solver.setObjective(Theorem.create("U"));
        solver.solve();
    }
}
