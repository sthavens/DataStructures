package org.example;

public class LinkedList<T> implements IList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int length;
    public LinkedList() {
        this.head = null;
    }

    private enum NodeType{
        Head,
        Tail,
        Other
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
    public Optional<T> remove(int index) {
        NodeType nodeType = determineNodeType(index);
        switch (nodeType) {
            case Head -> {
                return popFront();
            }
            case Tail -> {
                return popRear();
            }
        }

        if(index >= this.length) { //beyond bounds of LinkedList
            return new EmptyOption<>();
        }

        Node<T> cursor = getPreviousItem(index);
        T returnValue = removeCorrectItem(cursor);


        return new SomeOption<>(returnValue);
    }

    private Node<T> getPreviousItem(int index) {
        Node<T> cursor = head;

        for(int i = 0; i < index - 1; i++) {
            cursor = cursor.getNext();
        }
        return cursor;
    }

    private NodeType determineNodeType(int index) {
        if(index == 0){
            return NodeType.Head;
        } else if (index == this.length - 1) {
            return NodeType.Tail;
        } else {
            return NodeType.Other;
        }
    }

    private T removeCorrectItem(Node<T> cursor) {
        Node<T> temp = cursor.getNext();
        cursor.next = temp.getNext();
        this.length--;
        return finalizeNode(temp);
    }

    @Override
    public Optional<T> popRear() {
        if(length == 0) {
            return new EmptyOption<>();
        }
        Node<T> cursor = head;
        for(int i = 0; i < this.length - 2; i++){
            cursor = cursor.getNext();
        }
        Node<T> temp = tail;
        tail = cursor;
        this.length--;
        if(this.length == 0) {
            head = null;
            tail = null;
        }
        return new SomeOption<>(finalizeNode(temp));
    }

    @Override
    public Optional<T> popFront() {
        if(length == 0) {
            return new EmptyOption<>();
        }
        Node<T> temp = head;
        head = head.getNext();
        this.length--;
        if(this.length == 0) {
            head = null;
            tail = null;
        }
        return new SomeOption<>(finalizeNode(temp));
    }

    private T finalizeNode(Node<T> temp) {
        temp.unlink();
        return temp.unwrapData();
    }

    @Override
    public boolean append(T data) {
        Node<T> newNode = new Node<>(data);
        try {
            if (this.head == null) {
                this.head = newNode;
            } else {
                Node<T> temp = tail;
                temp.next = newNode;
            }
            this.tail = newNode;
        }
        catch (java.lang.OutOfMemoryError e) {
            System.out.println("Out of Memory Error Detected");
            return false;
        }
        this.length++;
        return true;
    }

    @Override
    public int getLength() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    public Node<T> head() {
        return this.head;
    }

    public Node<T> tail() {
        return this.tail;
    }
}
