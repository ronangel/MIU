package com.github.ronangel.miu.rules;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.ArrayList;
import java.util.List;

public class RuleTwo implements Rule {

    @Override
    public List<Theorem> apply(Theorem theorem) {
        List<Theorem> theorems = new ArrayList<>(1);
        theorems.add(theorem.append(theorem.toString().substring(1)));
        return theorems;
    }
}
