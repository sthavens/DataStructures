package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<String> testList;

    @BeforeEach
    void setUp() {
        testList = new LinkedList<>();
    }

    @Test
    void emptyListHasNullHeadAndTail() {
        assertNull(testList.head());
        assertNull(testList.tail());
    }

    @Test
    void insertIntoEmptyListMakesHeadAndTailTheSameAndLengthOfOne() {
        testList.insert("test");
        assertEquals("test", testList.head().getData());
        assertEquals(testList.head(), testList.tail());
        assertEquals(1, testList.getLength());
    }

    @Test
    void insertTwoItemsHaveCorrectHeadAndTailAndLengthOfTwo() {
        testList.insert("Tail");
        testList.insert("Head");
        assertEquals("Head", testList.head().getData());
        assertEquals("Tail", testList.tail().getData());
        assertEquals(2, testList.getLength());
    }

    @Test
    void insertThreeItemsHaveCorrectHeadAndTailAndLengthOfThree(){
        testList.insert("Tail");
        testList.insert("Middle");
        testList.insert("Head");
        assertEquals(testList.head().getData(), "Head");
        assertEquals(testList.tail().getData(), "Tail");
        assertEquals(3, testList.getLength());
    }

    @Test
    void insertOneItemThenRemoveTheItemGivesEmptyListAndLengthOfZero() {
        testList.insert("Doesn't Matter");
        testList.remove(0);
        assertNull(testList.head());
        assertNull(testList.tail());
        assertEquals(0, testList.getLength());
    }

    @Test
    void insertTwoItemsThenRemoveFirstItemLeavesTheRemainingItemHeadAndTailAreTheSameAndLengthOfOne() {
        testList.insert("Stays");
        testList.insert("Goes");
        Optional<String> returnedValue = testList.remove(0);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("Stays", testList.head().getData());
        assertEquals("Stays", testList.tail().getData());
        assertEquals(testList.head(), testList.tail());
        assertEquals(1, testList.getLength());
        assertEquals("Goes", returnedString);
    }

    @Test
    void insertThreeItemsThenRemoveMiddleItemLeavesFirstAndLastItemAndLengthOfTwo() {
        testList.insert("First");
        testList.insert("Middle");
        testList.insert("Last");
        Optional<String> returnedValue = testList.remove(1);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("Last", testList.head().getData());
        assertEquals(testList.head().getNext(), testList.tail());
        assertEquals("First", testList.tail().getData());
        assertEquals(2, testList.getLength());
        assertEquals("Middle", returnedString);
    }

    @Test
    void insertThreeItemsThenRemoveLastUpdatesTail() {
        testList.insert("Deleted");
        testList.insert("Tail");
        testList.insert("Head");
        Optional<String> returnedValue = testList.remove(2);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("Tail", testList.tail().getData());
        assertEquals("Head", testList.head().getData());
        assertEquals("Deleted", returnedString);
    }

    @Test
    void RemoveItemFromEmptyListReturnsEmptyOption() {
        Optional<String> returnedValue = testList.remove(0);
        assertFalse(returnedValue.isPresent());
        assertNull(returnedValue.get());
    }

    @Test
    void RemoveItemOutsideOfBoundsFromPopulatedListReturnsEmptyOption() {
        testList.insert("Not Used");
        Optional<String> returnedValue = testList.remove(1);
        assertFalse(returnedValue.isPresent());
        assertNull(returnedValue.get());
    }

    @Test
    void append() {
    }


    @Test
    void isEmpty() {
    }
}