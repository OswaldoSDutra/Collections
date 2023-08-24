package com.swd.data.structures.stack;

public class Stack {

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }
    }

    private int height;
    private Node top;

    public Stack(int value){
        Node newNode = new Node(value);
        this.top = newNode;
        height++;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (height == 0) {
            System.out.println("Top: null");
        } else {
            System.out.println("Top: " + top.value);
        }
        System.out.println("Height: " + height);
        System.out.println("\nStack:");
        if (height == 0) {
            System.out.println("empty");
        } else {
            printStack();
        }
    }

    public void makeEmpty() {
        top = null;
        height = 0;
    }

    public void push(int value){
        Node newNode = new Node(value);

        if(height > 0){
            newNode.next = top;
        }

        top = newNode;
        height++;
    }

    public Node pop(){

        if(height == 0)
            return null;

        Node temp = top;
        if(height == 1){
            top = null;
        } else {
            top = top.next;
            temp.next = null;
        }

        height--;
        return temp;
    }

}
