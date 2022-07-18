package com.java.programs.ds.linkedlist;

import java.util.Scanner;

public class InsertNodeInSortedLL {
    private ListNode head;
    static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        InsertNodeInSortedLL insertNodeInSortedLL = new InsertNodeInSortedLL();

        System.out.println("---welcome----");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Insert value");
            insertNodeInSortedLL.insertNode(scanner.nextInt());
            System.out.println("Again?   press 0");;
            continue;
        } while (scanner.nextInt() == 0);

        insertNodeInSortedLL.display();
    }

    public  void insertNode(int data){

        ListNode node = new ListNode(data);
        if (null == head){
            head = node;
            head.next = null;
        }else {
            ListNode current = head;
            while (null != current.next){
                current = current.next;
            }
            current.next = node;
        }
    }
    public  void display(){
        System.out.println("displaying list");
        while (null != head){
            System.out.println("data "+head.data);
            head = head.next;
        }
    }
}
