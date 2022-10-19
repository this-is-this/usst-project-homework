package com.whatisme;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static String input(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        System.out.println("计算器");
        System.out.println("仅支持整数输入");
        System.out.println("输出方式:分数(默认)  frac");
        System.out.println("       小数        decimal");
        boolean fracFlag = true;
        while (true) {
            String s = input(">>>");
            if ("exit".equals(s))
                break;
            else if ("frac".equals(s)) {
                System.out.println("分数模式");
                fracFlag = true;
                continue;
            } else if ("decimal".equals(s)) {
                System.out.println("小数模式");
                fracFlag = false;
                continue;
            }
            var ans = new Calculation(s).calculate().toString(fracFlag);
            System.out.println(ans);
        }
    }
}