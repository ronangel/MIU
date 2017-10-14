package com.github.ronangel.miu.rules;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.ArrayList;
import java.util.List;

public class RuleThree implements Rule {

    @Override
    public List<Theorem> apply(Theorem theorem) {
        List<Theorem> theorems = new ArrayList<>();

        int iiiIndex = 0;

        while ((iiiIndex = theorem.toString().indexOf("III", iiiIndex)) >=0)
        {
            theorems.add(theorem.replace(3, "U", iiiIndex));

            iiiIndex++;
        }

        return theorems;
    }
}
