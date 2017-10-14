package com.github.ronangel.miu.constructs;

public class Theorem {

    public Theorem replace(int charsToReplace, String with, int startingIndex) {
        return Theorem.create(string.substring(0, startingIndex) + with + string.substring(startingIndex + charsToReplace));
    }

    public static class Axioms {

        public static final Theorem MI = new Theorem("MI");

    }

    private final String string;

    private Theorem(String string) {
        this.string = string;
    }

    public static Theorem create(String string) {
        validate(string);

        return new Theorem(string);
    }

    public boolean endsWith(Symbols s) {
        return string.endsWith(s.toString());
    }

    public Theorem append(Symbols s) {
        return Theorem.create(string + s.toString());
    }

    public Theorem append(String str) {
        return Theorem.create(string + str);
    }

    private static void validate(String string) {
        if (string == null)
            throw new IllegalArgumentException("string cannot be null");

        for (Character c : string.toCharArray())
        {
            try
            {
                Symbols.lookup(c.toString());
            }
            catch (IllegalArgumentException e)
            {
                throw new IllegalArgumentException("string contains one or more invalid characters: \"" + string + "\"");
            }
        }
    }

    @Override
    public String toString() {
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Theorem theorem = (Theorem) o;

        return string.equals(theorem.string);
    }

    @Override
    public int hashCode() {
        return string.hashCode();
    }
}
