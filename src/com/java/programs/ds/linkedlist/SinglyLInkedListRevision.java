package com.java.programs.ds.linkedlist;
//https://www.youtube.com/watch?v=6iCHf7OZn6c&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d

public class SinglyLInkedListRevision {
    private  ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLInkedListRevision lInkedListRevision = new SinglyLInkedListRevision();

        lInkedListRevision.head = new ListNode(10);
        ListNode second = new ListNode(20);
        ListNode third = new ListNode(30);
        ListNode four = new ListNode(40);
        ListNode five = new ListNode(50);
        ListNode six = new ListNode(60);
        ListNode seven = new ListNode(70);

        lInkedListRevision.head.next = second;
        second.next = third;
        third.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;


     //   lInkedListRevision.display(head);

        ListNode newNode1 = new ListNode(11);
        ListNode newNode2 = new ListNode(22);
        ListNode newNode3 = new ListNode(33);

        newNode1.next = newNode2;
        newNode2.next = newNode3;


//        lInkedListRevision.insertNewLLAtFirst(newNode1);
//        lInkedListRevision.insertNewLLAtLast(newNode1);
//        lInkedListRevision.insertAtPosition(3,newNode1);
//        lInkedListRevision.deleteFromFirst(newNode1);
//        lInkedListRevision.deleteFromBetween(newNode1);
//        lInkedListRevision.reverse();
        lInkedListRevision.findMiddle();
    }
    public void display(){
        ListNode current = head;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public void insertNewLLAtFirst(ListNode newNode){

        ListNode current = head;
        head = newNode;

        while (newNode.next != null){
            newNode = newNode.next;
        }
        newNode.next =current;

        int count = 0;
        while (head != null){
            count++;
            System.out.println("data "+head.data +"--count --"+count);
            head = head.next;
        }

   }


   public void  insertNewLLAtLast(ListNode node){
        ListNode current = head;

        while (null != current.next){
            current = current.next;
        }
        current.next = node;

        while (null != head){
            System.out.println("data is "+head.data);
            head = head.next;
        }
    }

    public void insertAtPosition(int position, ListNode newLinkedList){
        if (head == null){
            newLinkedList.next = head;
            head = newLinkedList;
        }else {
            ListNode previousNode = head;
            int count =1;
            while (count < position-1){
                previousNode = previousNode.next;
                count++;
            }
            ListNode current = previousNode.next;
            previousNode.next = newLinkedList;
            while (null != newLinkedList.next){
                newLinkedList = newLinkedList.next;
            }
            newLinkedList.next = current;

            while ( null != head){
                System.out.println("data is "+ head.data);
                head = head.next;
            }
        }
    }

    public void deleteFromFirst(ListNode secondLinkedList){

    //delete first n node
        ListNode temp = head;
        int count = 1;

        while (count<=4){
            System.out.println("deleted "+head.data);
            head = head.next;
            count++;
        }
        temp = head;
        head = temp;

        while (null != head){
            System.out.println("data "+ head.data);
            head = head.next;
        }


    }

    public void deleteFromLast(ListNode secondLinkedList){

        //delete last n node
        ListNode temp = head;
        int count = 1;

        while (count<=4){
            System.out.println("deleted "+head.data);
            head = head.next;
            count++;
        }
        temp = head;
        head = temp;

        while (null != head){
            System.out.println("data "+ head.data);
            head = head.next;
        }
    }
    public void deleteFromBetween(ListNode node){
        ListNode previous = head;
        int dltStartIndx =3;
        int count =1;
        while (count < dltStartIndx){
            previous = previous.next;
            count++;
        }
        ListNode current = previous.next;

        int countt =1;
        while (countt < dltStartIndx){
            System.out.println("deleted node " +current.data);
            countt++;
            current = current.next;
        }
        previous.next = current.next;
        while (null != head){
            System.out.println("data is "+ head.data);
            head = head.next;
        }
    }

    public void reverse(){
        System.out.println("inside rev");
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;
        while (null != current){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        while (null != head){
            System.out.println("data "+head.data);
        head= head.next;
        }


    }
    public void findMiddle(){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (null != head){
            System.out.println(head.data);
            head = head.next;
        }

        while (null != fastPtr && null != fastPtr.next){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println(slowPtr.data);
    }

}



