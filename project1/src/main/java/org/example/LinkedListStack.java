package org.example;

public class LinkedListStack<T> implements IStack<T>{
    private final LinkedList<T> stack = new LinkedList<>();
    @Override
    public boolean push(T data) {
        return stack.insert(data);
    }

    @Override
    public Optional<T> pop() {
        return stack.popFront();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T peek() throws IndexOutOfBoundsException{
        Optional<T> temp = stack.peekData(0);
        if (temp.isPresent()) {
            return temp.get();
        }
        else {
            throw new IndexOutOfBoundsException("Peek attempted on empty stack");
        }
    }

    @Override
    public boolean isFull() {
        return false; // Theoretically never full stack. Throws exception when host is out of memory.
    }

    @Override
    public int length() {
        return stack.getLength();
    }
}
