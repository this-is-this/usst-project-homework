package com.whatisme;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class BigFrac {
    public final static BigFrac ZERO = new BigFrac();
    public final static BigFrac TEN = new BigFrac(10, 1);
    BigInteger x, y;

    public BigFrac() {
        x = BigInteger.ZERO;
        y = BigInteger.ONE;
    }

    public BigFrac(BigInteger x, BigInteger y) {
        if (y.equals(BigInteger.ZERO)) throw new ArithmeticException("Divide by Zero.");
        this.x = x;
        this.y = y;
    }

    public BigFrac(int x, int y) {
        this(BigInteger.valueOf(x), BigInteger.valueOf(y));
    }

    public static BigFrac valueOf(int x) {
        return new BigFrac(x, 1);
    }

    private void clean() {
        var g = x.gcd(y);
        x = x.divide(g);
        y = y.divide(g);
    }

    @Override
    public String toString() {
        clean();
        if (y.equals(BigInteger.ONE)) return x.toString();
        else return x.toString() + "/" + y.toString();
    }

    public String toString(boolean frac) {
        if (frac) return toString();
        else return new BigDecimal(x).divide(new BigDecimal(y), 20, RoundingMode.DOWN).toString();
    }

    public BigFrac negate() {
        return new BigFrac(x.negate(), y);
    }

    public BigFrac add(BigFrac b) {
        return new BigFrac(x.multiply(b.y).add(y.multiply(b.x)), y.multiply(b.y));
    }

    public BigFrac multiply(BigFrac b) {
        return new BigFrac(x.multiply(b.x), y.multiply(b.y));
    }

    public BigFrac divide(BigFrac b) {
        return new BigFrac(x.multiply(b.y), y.multiply(b.x));
    }

    public boolean equals(BigFrac b) {
        return x.multiply(b.y).equals(b.x.multiply(y));
    }
}
