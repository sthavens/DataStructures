package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListStackTest {

    LinkedListStack<String> testStack;
    @BeforeEach
    void setUp() {
        testStack = new LinkedListStack<>();
    }

    @Test
    void pushOneItemToEmptyListReturnsTrueAndHasSizeOfOne() {
        assertTrue(testStack.push("First"));
        assertEquals(1, testStack.length());
    }

    @Test
    void pushTwoItemsToEmptyListReturnsTrueTwiceAndHasSizeOfTwo() {
        assertTrue(testStack.push("First"));
        assertTrue(testStack.push("Second"));
        assertEquals(2, testStack.length());
    }

    @Test
    void popOnEmptyListReturnsEmptyOption() {
        assertInstanceOf(EmptyOption.class, testStack.pop());
    }

    @Test
    void popOnOneItemReturnsSomeOptionAndCorrectValue() {
        testStack.push("Test");
        Optional<String> returnOption = testStack.pop();
        assertInstanceOf(SomeOption.class, returnOption);
        assertEquals("Test", returnOption.get());
    }

    @Test
    void EmptyStackIsEmpty() {
        assertTrue(testStack.isEmpty());
    }

    @Test
    void NonEmptyStackIsNotEmpty() {
        testStack.push("Irrelevant");
        assertFalse(testStack.isEmpty());
    }

    @Test
    void peekOnEmptyStackReturnsEmptyOption() {
        assertThrowsExactly(IndexOutOfBoundsException.class, () -> testStack.peek());
    }

    @Test
    void peekOnPopulatedStackReturnsCorrectValue() {
        testStack.push("Test");
        String returnString = testStack.peek();
        assertEquals("Test", returnString);
    }

    @Test
    void linkedListAlwaysReturnsNotFull() {
        assertFalse(testStack.isFull());
    }
}