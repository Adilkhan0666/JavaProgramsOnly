package com.java.programs.loop;

import java.util.Scanner;

public class Prime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        int temp = 0;
        for (int i = 2; i < number - 1; i++) {
            if (number % 2 == 0) {
                temp += 1;
                break;
            }
        }
        if (temp > 0) {
            System.out.println("not prime");
        } else {
            System.out.println("prime");
        }
    }
}
