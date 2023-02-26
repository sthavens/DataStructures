package org.example;

public interface IStack<T> {
    boolean push(T data);
    Optional<T> pop();
    boolean isEmpty();
    T peek();
    boolean isFull();
    int length();
}
