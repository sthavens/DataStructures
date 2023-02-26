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
        assertNull(testList.Head());
        assertNull(testList.Tail());
    }

    @Test
    void insertIntoEmptyListMakesHeadAndTailTheSameAndLengthOfOne() {
        testList.insert("test");
        assertEquals("test", testList.Head().getData());
        assertEquals(testList.Head(), testList.Tail());
        assertEquals(1, testList.getLength());
    }

    @Test
    void insertTwoItemsHaveCorrectHeadAndTailAndLengthOfTwo() {
        testList.insert("Tail");
        testList.insert("Head");
        assertEquals("Head", testList.Head().getData());
        assertEquals("Tail", testList.Tail().getData());
        assertEquals(2, testList.getLength());
    }

    @Test
    void insertThreeItemsHaveCorrectHeadAndTailAndLengthOfThree(){
        testList.insert("Tail");
        testList.insert("Middle");
        testList.insert("Head");
        assertEquals(testList.Head().getData(), "Head");
        assertEquals(testList.Tail().getData(), "Tail");
        assertEquals(3, testList.getLength());
    }

    @Test
    void insertOneItemThenRemoveTheItemGivesEmptyListAndLengthOfZero() {
        testList.insert("Doesn't Matter");
        testList.remove(0);
        assertNull(testList.Head());
        assertNull(testList.Tail());
        assertEquals(0, testList.getLength());
    }

    @Test
    void insertTwoItemsThenRemoveFirstItemLeavesTheRemainingItemHeadAndTailAreTheSameAndLengthOfOne() {
        testList.insert("Stays");
        testList.insert("Goes");
        Optional<String> returnedValue = testList.remove(0);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("Stays", testList.Head().getData());
        assertEquals("Stays", testList.Tail().getData());
        assertEquals(testList.Head(), testList.Tail());
        assertEquals(1, testList.getLength());
        assertEquals("Goes", returnedValue);
    }

    @Test
    void append() {
    }


    @Test
    void isEmpty() {
    }
}