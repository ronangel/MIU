package com.github.ronangel.miu.constructs;

public enum Symbols {

    M("M"),
    I("I"),
    U("U");

    private final String val;

    private Symbols(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val;
    }

    public static Symbols lookup(String str) {
        if (str.equals("M"))
            return M;

        if (str.equals("I"))
            return I;

        if (str.equals("U"))
            return U;

        throw new IllegalArgumentException(str);
    }
}
