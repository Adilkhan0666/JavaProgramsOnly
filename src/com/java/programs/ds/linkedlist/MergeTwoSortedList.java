package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class MergeTwoSortedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();

        ListNode first = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode four = new ListNode(40);
        ListNode five = new ListNode(50);
        ListNode six = new ListNode(60);
        ListNode seven = new ListNode(70);

        first.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;


        ListNode uno = new ListNode(11);
        ListNode dos = new ListNode(22);
        ListNode tres = new ListNode(33);

        uno.next = dos;
        dos.next = tres;

         ListNode head = mergeTwoSortedList.mergeList(first,uno);
         while (null != head){
             System.out.println(head.data);
             head = head.next;
         }

    }

    private  ListNode mergeList(ListNode first, ListNode uno) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (null != first && null != uno){
            if (first.data <= uno.data){
                tail.next = first;
                first = first.next;
            }else {
                tail.next = uno;
                uno = uno.next;
            }
            tail = tail.next;
        }
        if (null == first){
            tail.next = uno;
        }else {
            tail.next = first;
        }
        return dummy.next;
    }
}