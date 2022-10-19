package com.whatisme;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Deque;

class Calculation {
    String s;
    int n;

    public Calculation(String s) {
        this.s = s;
        n = s.length();
    }

    private boolean check(char c) {
        if (Character.isDigit(c))
            return true;
        switch (c) {
            case '+', '-', '*', '/', ' ' -> {
                return true;
            }
            default -> {
                return false;
            }
        }
    }

    public String calculate() {
        Deque<BigInteger> stack = new ArrayDeque<>();
        char preSign = '+';
        BigInteger num = BigInteger.ZERO;
        for (int i = 0; i < n; ++i) {
            if (Character.isDigit(s.charAt(i))) {
                num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(s.charAt(i) - '0'));
            }
            if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == n - 1) {
                switch (preSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(num.negate());
                    case '*' -> stack.push(stack.pop().multiply(num));
                    case '/' -> stack.push(stack.pop().divide(num));
                }
                preSign = s.charAt(i);
                if (!check(preSign))
                    return "Invalid Input";
                num = BigInteger.ZERO;
            }
        }
        BigInteger ans = BigInteger.ZERO;
        while (!stack.isEmpty()) {
            ans = ans.add(stack.pop());
        }
        return ans.toString();
    }
}
