package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmptyOptionTest {

    Optional<?> emptyInstance;

    @BeforeEach
    void setUp() {
        emptyInstance = EmptyOption.EMPTY;
    }

    @Test
    void get() {
        assertNull(emptyInstance.get());
    }

    @Test
    void isPresent() {
        assertFalse(emptyInstance.isPresent());
    }
}