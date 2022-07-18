package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class SinglyLInkedList {
    private ListNode head;

    static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode second =new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        head.next=second;
        second.next=third;
        third.next = fourth;

        SinglyLInkedList singlyLInkedList = new SinglyLInkedList();
//        singlyLInkedList.displayList(head);
//        ListNode listNode = singlyLInkedList.reverseList(head);
//        singlyLInkedList.displayList(listNode);

        endToFirst(head);

    }
    public static void endToFirst(ListNode head){

        if(head.next != null) {
            endToFirst(head.next);
        }
        System.out.println(head.data);

    }

    public static void main1(String[] args) {
        SinglyLInkedList sLL = new SinglyLInkedList();
        sLL.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        sLL.head.next = second;  //
        second.next = third;
        third.next = fourth;
        sLL.displayList();
        System.out.println("length " + sLL.length());

        sLL.insertBefore(50);
        sLL.insertBefore(60);
        sLL.displayList();
        System.out.println("length " + sLL.length());
        sLL.insertAfter(70);
        sLL.insertAfter(80);
        sLL.displayList();
        System.out.println("length " + sLL.length());
        sLL.insertAt(1, 100);
        sLL.displayList();
        System.out.println("length " + sLL.length());
        sLL.insertAt(2, 200);
        sLL.displayList();
        System.out.println("length " + sLL.length());
        sLL.insertAt(11, 300);
        sLL.displayList();
        System.out.println("length " + sLL.length());
        sLL.deleteFirst();
        sLL.displayList();
        System.out.println("length " + sLL.length());
        sLL.displayList();
        System.out.println("length " + sLL.length());
        System.out.println("ELEMENT AT INDEX "+sLL.searchElementIndex(300));;
        sLL.displayList();
        System.out.println("ELEMENT Exist "+sLL.searchElementExist(30));;
        sLL.displayList();
        System.out.println("revv: " +sLL.reverseList(sLL.head));


    }

    public void displayList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");

    }

    public void displayList(ListNode node) {
        ListNode current = node;
        while (current != null) {
            System.out.print(current.data + "-->");
            current = current.next;
        }
        System.out.println("null");

    }

    public int length() {
        if (head == null)
            return 0;

        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public void insertBefore(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    public void insertAfter(int data) {
        ListNode node = new ListNode(data);

        if (head == null) {
            head = node;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
    }

    public void insertAt(int position, int data) {
        ListNode node = new ListNode(data);
        if (position == 1) {
            node.next = head;
            head = node;
        } else {
            ListNode previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            node.next = current;
            previous.next = node;
        }

    }

    public ListNode deleteFirst() {
        if (head == null)
            return null;
        ListNode current = head;
        head = head.next;
        current.next = null;
        return current;
    }

    public ListNode deleteLast() {
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        return current;
    }

    public int searchElementIndex(int data){

        ListNode current = head;
        int count=1;
        while (current.data != data){
            current = current.next;
            count++;
        }
        return  count;
    }
    public boolean searchElementExist(int data){
        ListNode current = head;
        while (current.next!=null){
            if (current.data==data){
                return  true;
            }
            current =current.next;
        }return false;
    }
    public ListNode  reverseList(ListNode node){
        if (node == null)
            return  node;
        ListNode current = node;
        ListNode next =null;
        ListNode previous = null;

        while (current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return  previous;
    }
}










