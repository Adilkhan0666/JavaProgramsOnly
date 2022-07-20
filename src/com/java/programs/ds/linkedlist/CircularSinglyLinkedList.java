package com.java.programs.ds.linkedlist;

import java.util.List;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }

    }
    public CircularSinglyLinkedList(){
        this.last = null;
        this.length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;
    }


    public void createCircularLinkedList(){
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        last = node4;
    }

    public void display(){
        if (last == null)
            return;

        ListNode first = last.next;
        while (first != last){
            System.out.println("data is  "+first.data);
            first = first.next;
        }
        System.out.println("data is  "+first.data);
    }
    public void insertFirst(int data){
        ListNode temp = new ListNode(data);

        if (null == last){
            last = temp;
        }else {
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }
    public void insertLast(int data){
        ListNode temp = new ListNode(data);
        if (null == last) {
            last = temp;
            last.next = last;
        }else {
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    public void deleteFirst(){
        ListNode temp = last.next;
        if (last.next == null){
            last = null;
        }else {
            last.next = temp.next;
        }
        temp.next = null;
        length--;

    }
    public static void main(String[] args) {

        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();
        circularSinglyLinkedList.createCircularLinkedList();
        circularSinglyLinkedList.insertFirst(123);
        circularSinglyLinkedList.insertLast(321);
        circularSinglyLinkedList.insertLast(321123);
        circularSinglyLinkedList.deleteFirst();
        circularSinglyLinkedList.display();

    }



}
