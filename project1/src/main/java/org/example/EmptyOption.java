package org.example;

public class EmptyOption<T> implements Optional<T>{

    static final EmptyOption<?> EMPTY = new EmptyOption<>();

    public EmptyOption() {}

    @java.lang.Override
    public T get() {
        return null;
    }

    @java.lang.Override
    public boolean isPresent() {
        return false;
    }

}
