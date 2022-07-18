package com.java.programs.loop;


class loop {
    public static void main(String[] args) {

        int start = 0;
        int sum = 0 ;
        for (int i = start; i <=4 ; i++) {
            System.out.println("counting  "  + i);
            sum+=i;
        }
        System.out.println("sum is : " + sum);
    }
}