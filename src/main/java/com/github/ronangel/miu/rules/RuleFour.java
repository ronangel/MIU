package com.github.ronangel.miu.rules;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.ArrayList;
import java.util.List;

public class RuleFour implements Rule {

    @Override
    public List<Theorem> apply(Theorem theorem) {
        List<Theorem> theorems = new ArrayList<>();

        int UUIndex = 0;

        while ((UUIndex = theorem.toString().indexOf("UU", UUIndex)) >=0)
        {
            theorems.add(theorem.replace(2, "", UUIndex));

            UUIndex++;
        }

        return theorems;
    }
}
