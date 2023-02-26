package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OptionalTest {

    @Test
    void emptyReturnsEmptyOption() {
        assertInstanceOf(EmptyOption.class, Optional.empty());
    }

    @Test
    void someReturnsSomeOption() {
        assertInstanceOf(SomeOption.class, Optional.some("Test"));
    }
}