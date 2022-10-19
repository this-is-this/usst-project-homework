package com.whatisme;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculationTest {
    private static void assertEquals(BigFrac a, BigFrac b) {
        assertTrue(a.equals(b));
    }

    @Test
    public void testCalculation() {
        assertEquals(new Calculation("1+1").calculate(), BigFrac.valueOf(2));
        assertEquals(new Calculation(" 1+ 3").calculate(), BigFrac.valueOf(4));
        assertEquals(new Calculation("99/10").calculate(), new BigFrac(99, 10));
        assertEquals(new Calculation("100000000000000000000000000000000*100000000000000000000000000000").calculate(),
                new BigFrac(new BigInteger("10000000000000000000000000000000000000000000000000000000000000"), BigInteger.ONE));
        assertEquals(new Calculation("1+2*3").calculate(), BigFrac.valueOf(7));
        assertEquals(new Calculation("2*(1+1)").calculate(), BigFrac.valueOf(4));
    }
}
