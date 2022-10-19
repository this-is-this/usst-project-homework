package com.whatisme;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculation {
    String s;
    int i, end;

    public Calculation(String s) {
        this.s = s;
        i = 0;
        end = s.length() - 1;
    }

    public BigDecimal calculate() {
        Deque<BigDecimal> stack = new ArrayDeque<>();
        char preSign = '+';
        BigDecimal num = BigDecimal.ZERO;
        for (; i <= end; ++i) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;
            if (c == '(') {
                ++i;
                num = calculate();
            }
            if (Character.isDigit(c)) {
                num = num.multiply(BigDecimal.TEN).add(BigDecimal.valueOf(c - '0'));
            }
            if (!Character.isDigit(c) || i == end) {
                switch (preSign) {
                    case '+' -> stack.push(num);
                    case '-' -> stack.push(num.negate());
                    case '*' -> stack.push(stack.pop().multiply(num));
                    case '/' -> stack.push(stack.pop().divide(num, 100, RoundingMode.UNNECESSARY));
                }
                preSign = c;
                if (c == ')')
                    break;
                num = BigDecimal.ZERO;
            }
        }
        BigDecimal ans = BigDecimal.ZERO;
        while (!stack.isEmpty()) {
            ans = ans.add(stack.pop());
        }
        return ans;
    }
}
