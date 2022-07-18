package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class RemoveKey {
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
        RemoveKey removeKey= new RemoveKey();

        removeKey.insertAtBegining(10);
        removeKey.insertAtBegining(20);
        removeKey.insertAtBegining(30);
        removeKey.insertAtBegining(40);
        removeKey.insertAtBegining(50);
        removeKey.displayElement();
        removeKey.removeKey(30);
        removeKey.displayElement();
    }
    public void insertAtBegining(int data){
        ListNode node = new ListNode(data);

        if (null == head){
            head = node;
        }else {
            ListNode current = head;
            while (null != current.next){
                current = current.next;
            }
            current.next = node;

        }
    }

    public void displayElement(){
        System.out.println("printing");
        ListNode current = head;
        while (null != current){
            System.out.println("data "+ current.data);
            current = current.next;
        }
    }
    public void removeKey(int key){
        ListNode current = head;
        ListNode temp = null;

        if (null != current && key == current.data){
            head = current.next;
            return;
        }

        while (null != current && key != current.data){
            temp = current;
            current = current.next;
        }
        if (null == current){
            return;
        }
        temp.next = current.next;
    }
}