package com.java.programs.javaeight.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Java {

    //stream used to process collections object.
    public static void main(String[] args) {

        filterExample();
        mapExample();
        countExample();
        sortExample();

    }


    private static void sortExample() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(21);
        list.add(30);
        list.add(41);
        list.add(50);
        list.add(61);

        System.out.println(list);

        List<Integer> sorted = list.stream().sorted().collect(Collectors.toList());
        System.out.println("N S O sorted::: " + sorted);

        List<Integer> list1 = list.stream().sorted((I,I1)->-I.compareTo(I1)).collect(Collectors.toList());
        System.out.println("C S O sorted:: "+ list1);

    }
    private static void countExample() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(21);
        list.add(30);
        list.add(41);
        list.add(50);
        list.add(61);

        System.out.println(list);

        Long count = list.stream().count();
        System.out.println("count::: " + count);

    }

    private static void mapExample() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(21);
        list.add(30);
        list.add(41);
        list.add(50);
        list.add(61);

        System.out.println(list);

        List<Integer> list1 = list.stream().map(i->i+1).collect(Collectors.toList());
        System.out.println("mapp::: " + list1);

    }

    public static void filterExample(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(21);
        list.add(30);
        list.add(41);
        list.add(50);
        list.add(61);

        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        for (Integer i:list) {
            if (i%2==0){
                list1.add(i);
            }
        }
        System.out.println(list1);

        List<Integer> list2 = list.stream().filter(i -> i%2!=0).collect(Collectors.toList());
        System.out.println(list2);

    }

}