package com.github.ronangel.miu.rules;

import com.github.ronangel.miu.constructs.Theorem;

import java.util.List;

public interface Rule {
    List<Theorem> apply(Theorem theorem);
}
