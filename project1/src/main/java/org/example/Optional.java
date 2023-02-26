package org.example;

public interface Optional<T>{
    T get();
    boolean isPresent();
    static <T> Optional<T> empty() {
        return new EmptyOption<>();
    }

    static<T> Optional<T> some(T value) {
        return new SomeOption<>(value);
    }
}


