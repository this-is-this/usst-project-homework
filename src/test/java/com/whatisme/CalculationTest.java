package com.whatisme;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculationTest {
    @Test
    public void testCalculation() {
        assertEquals(new Calculation("1+1").calculate(), "2");
        assertEquals(new Calculation(" 1+ 3").calculate(), "4");
        assertEquals(new Calculation("99/10").calculate(), "9");
        assertEquals(new Calculation("100000000000000000000000000000000*100000000000000000000000000000").calculate(),
                "10000000000000000000000000000000000000000000000000000000000000");
        assertEquals(new Calculation("1+2*3").calculate(), "7");
    }
}
