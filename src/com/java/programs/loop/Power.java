package com.java.programs.loop;

public class Power {

    public static void main(String[] args) {
        int base = 2;
        int pow = 6;

        int result =1;
        for (int i = 1; i <= pow; i++) {
            result*=base;

        }
        System.out.println("result " +result);
    }
}
