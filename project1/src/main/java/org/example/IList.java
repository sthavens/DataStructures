package org.example;

public interface IList<T> {
    boolean insert(T data);
    T remove(int index);
    boolean append(T data);
    int length();
    boolean isEmpty();
}
