package com.swd.data.structures.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class SinglyLinkedList {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public SinglyLinkedList(int value){
        Node newNode = new Node(value);

        this.tail = this.head = newNode;
        this.length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value){
        Node newNode = new Node(value);

        if(length == 0){
            tail = head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        length++;
    }

    public Node removeLast() {
        Node current;

        if (length == 0)
            return null;

        if (length == 1){
            current = tail;
            head = null;
            tail = null;
        } else {
            current = head;

            while(current.next != tail) {
                current = current.next;
            }

            tail = current;
            current = current.next;
            tail.next = null;
        }

        length--;

        return current;
    }

    public Node removeLast2() {

        if (length == 0)
            return null;

        Node current, previous;

        current = head;
        previous = head;

        while(current.next != null){
            current = current.next;
            previous = current;

        }

        tail = previous;
        tail.next = null;

        length--;

        if(length == 0){
            head = null;
            tail = null;
        }

        return current;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;

        temp.next = null;

        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node get(int index){
        if (length == 0 || index < 0 || index >= length) return null;

        Node current = head;

        int currentIndex = 0;
        while(currentIndex < index){
            currentIndex++;
            current = current.next;
        }

        return current;
    }

    public boolean set(int index, int value) {

        Node temp = get(index);

        if(temp != null){
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value){

        //check if the index is valid (greater than 0, less or igual to the actual length)
        if(index < 0 || index > length)
            return false;

        // Use case: insert at the first position in an empty list
        if(index == 0 ){
            prepend(value);
        }

        // Use case: insert at a last position +1 index
        else if(index == length){
            append(value);
        }

        else {

            Node newNode = new Node(value);

    	    /*
    	    Reach the previous node of the desired index
    	    Put the next node of the previous (node at the actual desired index) into the next of newNode
    	    Put newNode in the next of previous
    	    */

            Node prev = get(index-1);

            newNode.next = prev.next;
            prev.next = newNode;

            length++;
        }

        return true;
    }

    public Node remove(int index){

        if (index < 0 || index >= length)
            return null;

        if (index == 0)
            return removeFirst();

        if(index == length-1)
            return removeLast();

        Node prev = get(index-1);

        Node nodeToRemove = prev.next;
        prev.next = nodeToRemove.next;
        nodeToRemove.next = null;

        length--;

        return nodeToRemove;
    }

    public void reverse(){

        Node prev = null;
        Node current = head;
        Node next = head.next;

        for(int i=0; i < length; i++){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        current = head;
        head = tail;
        tail = current;
    }

    public Node findMiddleNode(){

        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public boolean hasLoop(){
        Node slow, fast;

        slow = head;
        fast = head;

        while(fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public Node findKthFromEnd(int k){
        Node fast, slow;

        fast = slow = head;
        for(int i=0; i < k; i++){

            if(fast == null)
                return null;

            fast = fast.next;
        }

        while(fast != null){
            fast=fast.next;
            slow=slow.next;
        }

        return slow;

    }

    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node previous = null;
        Node current = head;
        while (current != null) {
            if (values.contains(current.value)) {
                previous.next = current.next;
                length -= 1;
            } else {
                values.add(current.value);
                previous = current;
            }
            current = current.next;
        }
    }

    public void reverseBetween(int m, int n) {
        if (head == null) return;

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 0; i < m; i++) {
            prev = prev.next;
        }

        Node current = prev.next;
        for (int i = 0; i < n - m; i++) {
            Node temp = current.next;
            current.next = temp.next;
            temp.next = prev.next;
            prev.next = temp;
        }

        head = dummy.next;
    }

    public void partitionList(int x) {
        Node prev, current, greater, tempP, tempG;

        if(head == null)
            return;

        current = head;

        tempP = new Node(0);
        tempG = new Node(0);

        prev = tempP;
        greater = tempG;

        while (current != null){

           if(current.value < x) {
               prev.next = current;
               prev = current;

           } else {
               greater.next = current;
               greater = current;
           }

           current = current.next;
        }

        greater.next = null;
        prev.next = tempG.next;

        head = tempP.next;
    }

}

