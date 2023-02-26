package org.example;

public interface IList<T> {
    boolean insert(T data);
    Optional<T> remove(int index);
    Optional<T> popFront();
    Optional<T> popRear();
    boolean append(T data);
    int getLength();
    boolean isEmpty();
    Optional<T> peekData(int index);
}
