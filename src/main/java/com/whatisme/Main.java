package com.whatisme;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static String input(String s) {
        System.out.print(s);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        while (true) {
            String s = input(">>>");
            if ("exit".equals(s)) break;
            String ans = new Calculation(s).calculate();
            System.out.println(ans);
        }
    }
}