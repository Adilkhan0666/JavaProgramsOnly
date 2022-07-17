package com.java.programs.javaeight.design.builder;

public class Main {
    public static void main(String[] args) {
        Mobile samsung = new Mobile.Builder("Samsung")
                .build();
        System.out.println(samsung);

        Mobile oppo = new Mobile.Builder("OPPO").setColour("grey").setProcessor("octa-core").setRam("8 GB").build();
        System.out.println(oppo);


    }
}
