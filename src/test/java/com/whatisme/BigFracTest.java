package com.whatisme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BigFracTest {
    private static void assertEquals(BigFrac a, BigFrac b) {
        assertTrue(a.equals(b));
    }

    @Test
    public void testAdd() {
        assertEquals(new BigFrac(1, 2).add(new BigFrac(1, 2)), BigFrac.valueOf(1));
        assertEquals(new BigFrac(1, 2).add(new BigFrac(-1, 3)), new BigFrac(1, 6));
        assertEquals(new BigFrac(1, 2).add(new BigFrac(1, 3)), new BigFrac(5, 6));
    }

    @Test
    public void testMultiply() {
        assertEquals(new BigFrac(1, 2).multiply(new BigFrac(1, 3)), new BigFrac(1, 6));
        assertEquals(new BigFrac(0, 2).multiply(new BigFrac(100, 3)), BigFrac.ZERO);
        assertEquals(new BigFrac(3, 2).multiply(new BigFrac(1, 3)), new BigFrac(1, 2));
    }

    @Test
    public void testDivide() {
        assertEquals(new BigFrac(1, 2).divide(new BigFrac(1, 3)), new BigFrac(3, 2));
        assertEquals(new BigFrac(0, 2).divide(new BigFrac(100, 3)), BigFrac.ZERO);
        assertEquals(new BigFrac(3, 2).divide(new BigFrac(1, 6)), new BigFrac(9, 1));
    }
}
