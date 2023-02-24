package org.example;

public class LinkedList<T> implements IList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int length;
    public LinkedList() {
        this.head = null;
    }

    @Override
    public boolean insert(T data) {
        Node<T> newNode = new Node<>(data);
        try {
            if (this.head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                newNode.next = head;
                this.head = newNode;
            }
        }
        catch (java.lang.OutOfMemoryError e) {
            System.out.println("Out of Memory Error Detected");
            return false;
        }
        this.length++;
        return true; //Linked lists are unbounded by definition
    }

    @Override
    public T remove(int index) {
        if(index >= this.length) { //beyond bounds of LinkedList
        }
        if(index == this.length - 1) { //removes tail
            Node<T> cursor = head;
            for(int i = 0; i < length - 1; i++) {
                cursor = cursor.getNext();
            }
            Node<T> temp = this.tail;
            this.tail = cursor;
        }
        return null; //fix
    }

    @Override
    public boolean append(T data) {
        return false;
    }

    @Override
    public int length() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
