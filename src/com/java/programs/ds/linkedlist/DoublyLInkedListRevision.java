package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class DoublyLInkedListRevision {
    private ListNode head;
    private ListNode tail;
    private int length;

    static class ListNode{
        private ListNode previous;
        private ListNode next;
        private int data;

        public ListNode(int data){
            this.data = data;
        }
    }

    public DoublyLInkedListRevision(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public static void main(String[] args) {

        DoublyLInkedListRevision revision = new DoublyLInkedListRevision();
        revision.insertLast(10);
        revision.insertLast(20);
        revision.insertLast(30);
        revision.insertLast(40);
        revision.insertFirst(5);
        revision.insertFirst(3);

        revision.displayForward();
    }
    public void displayForward(){
        ListNode temp = head;
        while ( null != temp){
            System.out.print(temp.data +"-->");
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
            node.previous = tail;
        }
        tail = node;
        length++;

    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length==0;//head == null
    }

    public void insertFirst(int data){
        ListNode node = new ListNode(data);
        if (isEmpty()){
            tail = node;
        }else {
            head.previous = node;
        }
        node.next = head;
        head = node;
        length++;
    }

}