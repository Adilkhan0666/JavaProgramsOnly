package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class DetectLoop {
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

        DetectLoop detectLoop = new DetectLoop();
        detectLoop.head = new ListNode(10);
        ListNode second =new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);
        ListNode fifth = new ListNode(50);
        ListNode sixth = new ListNode(60);

;
        detectLoop.head.next=second;
        second.next=third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = second;

        System.out.println(detectLoop.detectLoop());
        System.out.println(detectLoop.loopNode().data);;
        detectLoop.removeLoop();
    }
    public boolean detectLoop(){
        ListNode fastPtr = head;
        ListNode slowPtr = head;

        while (null != fastPtr && null != fastPtr.next){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }
    public ListNode loopNode(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (null != fastPtr && null != fastPtr.next){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr){
                return getLoopNode(slowPtr);
            }
        }
        return null;

    }

    private ListNode getLoopNode(ListNode slowPtr) {
        ListNode temp = head;
        while (slowPtr != temp){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }


    public void removeLoop(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (null != fastPtr && null != fastPtr.next){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (fastPtr == slowPtr){
                removeLoopFromLinkedList(slowPtr);
            }
        }
    }

    private void removeLoopFromLinkedList(ListNode slowPtr) {
        ListNode temp = head;

        while (slowPtr.next != temp.next){
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;

        while (null != head){
            System.out.println("data is :: "+ head.data);
            head = head.next;
        }

    }
}