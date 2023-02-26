package org.example;

public class SomeOption<T> implements Optional<T>{
    private final T value;

    public SomeOption(T value) {
        this.value = value;
    }

    @Override
    public T get() {
        return value;
    }

    @Override
    public boolean isPresent() {
        return true;
    }
}
