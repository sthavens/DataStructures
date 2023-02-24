package org.example;

public class Node<T> {
    T data;
    Node<T> next = null;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void unlink() {
        this.next = null;
    }

    public T unwrapData() {
        this.unlink();
        return this.data;
    }
}
