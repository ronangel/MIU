package com.github.ronangel.miu.rules;

import com.github.ronangel.miu.constructs.Symbols;
import com.github.ronangel.miu.constructs.Theorem;

import java.util.ArrayList;
import java.util.List;

public class RuleOne implements Rule {

    @Override
    public List<Theorem> apply(Theorem theorem) {
        List<Theorem> theorems = new ArrayList<>();

        if (theorem.endsWith(Symbols.I))
        {
            theorems.add(theorem.append(Symbols.U));
        }
        return  theorems;
    }
}
