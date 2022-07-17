package com.java.programs.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringPrograms {
    public static void main(String[] args) {
        String s = "Adil";
        System.out.println(s.replace("A","S"));

        List<String> list = new ArrayList<>();
        list.add("Adil");
        list.add("Abid");

        List<String> strings = list.stream().map(l -> l.replace("A","S")).collect(Collectors.toList());
        System.out.println(strings);


    }
}
