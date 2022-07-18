package com.java.programs.loop;


import java.util.Scanner;

class Factorial {
    public static void main(String[] args) {
        System.out.println(-(40%7));

        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        int fact = 1;
        for(int i =num ; i>=1;i--){
            fact*=i;
        }

        System.out.println("fact is "+ fact);

    }
}