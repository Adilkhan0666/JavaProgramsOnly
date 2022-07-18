package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class DoublyLInkedList {
    private ListNode head;
    private ListNode tail;
    private int length;


    static class ListNode {
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public DoublyLInkedList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int length(){
        return length;
    }


    public static void main(String[] args) {
        DoublyLInkedList doublyLInkedList = new DoublyLInkedList();

        doublyLInkedList.insertLast(10);
        doublyLInkedList.insertLast(20);
        doublyLInkedList.insertLast(30);

        doublyLInkedList.displayForward();
    }

    private void displayForward() {
        ListNode temp = head;
        while (null != temp){
            System.out.print(  temp.data+ "-->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void insertLast(int data){
        ListNode node = new ListNode(data);

        if (isEmpty()){
            head = node;
        }else {
            tail.next = node;
        }
        node.previous =tail;
        tail = node;
        length++;
    }

    public void insertFirst(int data){
        ListNode node = new ListNode(data);

        if (isEmpty()){
            tail = node;
        }else {
            head.previous =  node;
        }
        node.next = head;
        head = node;
        length++;

    }


}