package com.java.programs.loop;

public class Reverse {

    public static void main(String[] args) {
        int num = 12345;

        int remainder =0;
        int reverse=0;

        int temp = num;
        while(temp>0){

            remainder = temp%10;
            reverse= reverse*10 + remainder;
            temp=temp/10;
        }
        System.out.println("reverse is " + reverse);
    }
}
