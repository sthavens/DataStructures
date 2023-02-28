package org.example;

import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    LinkedList<String> testList;

    private static final int KILO = 1024;
    private static final int MEGA = 1024 * KILO;

    @BeforeEach
    void setUp() {
        testList = new LinkedList<>();
    }

    void createListWithOneItem() {
        testList.insert("First");
    }

    void createListWithTwoItems() {
        createListWithOneItem();
        testList.insert("Second");
    }

    void createListWithThreeItems() {
        createListWithTwoItems();
        testList.insert("Third");
    }

    void createListWithFourItems() {
        createListWithThreeItems();
        testList.insert("Fourth");
    }


    @Test
    void emptyListHasNullHeadAndTailAndLengthOfZero() {
        assertNull(testList.head());
        assertNull(testList.tail());
        assertTrue(testList.isEmpty());
        assertEquals(0, testList.getLength());
    }

    @Test
    void successfullyInsertingItemReturnsTrue() {
        assertTrue(testList.insert("Test"));
    }

    @Test
    void insertIntoEmptyListMakesHeadAndTailTheSameAndLengthOfOne() {
        createListWithOneItem();
        assertEquals("First", testList.head().getData());
        assertEquals(testList.head(), testList.tail());
        assertEquals(1, testList.getLength());
    }

    @Test
    void insertTwoItemsHaveCorrectHeadAndTailAndLengthOfTwo() {
        createListWithTwoItems();
        assertEquals("Second", testList.head().getData());
        assertEquals("First", testList.tail().getData());
        assertEquals(2, testList.getLength());
    }

    @Test
    void insertThreeItemsHaveCorrectHeadAndTailAndLengthOfThree() {
        createListWithThreeItems();
        assertEquals(testList.head().getData(), "Third");
        assertEquals(testList.tail().getData(), "First");
        assertEquals(3, testList.getLength());
    }

    @Test
    void insertOneItemThenRemoveTheItemGivesEmptyListAndLengthOfZero() {
        createListWithOneItem();
        testList.remove(0);
        assertNull(testList.head());
        assertNull(testList.tail());
        assertEquals(0, testList.getLength());
        assertTrue(testList.isEmpty());
    }

    @Test
    void insertTwoItemsThenRemoveFirstItemLeavesTheRemainingItemHeadAndTailAreTheSameAndLengthOfOne() {
        createListWithTwoItems();
        Optional<String> returnedValue = testList.remove(0);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("First", testList.head().getData());
        assertEquals("First", testList.tail().getData());
        assertEquals(testList.head(), testList.tail());
        assertEquals(1, testList.getLength());
        assertEquals("Second", returnedString);
    }

    @Test
    void insertThreeItemsThenRemoveMiddleItemLeavesFirstAndLastItemAndLengthOfTwo() {
        createListWithThreeItems();
        Optional<String> returnedValue = testList.remove(1);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("Third", testList.head().getData());
        assertEquals(testList.head().getNext(), testList.tail());
        assertEquals("First", testList.tail().getData());
        assertEquals(2, testList.getLength());
        assertEquals("Second", returnedString);
    }

    @Test
    void insertThreeItemsThenRemoveLastUpdatesTail() {
        createListWithThreeItems();
        Optional<String> returnedValue = testList.remove(2);
        assertTrue(returnedValue.isPresent());
        String returnedString = returnedValue.get();
        assertEquals("Second", testList.tail().getData());
        assertEquals("Third", testList.head().getData());
        assertEquals("First", returnedString);
    }

    @Test
    void RemoveItemFromEmptyListReturnsEmptyOption() {
        Optional<String> returnedValue = testList.remove(0);
        assertFalse(returnedValue.isPresent());
        assertNull(returnedValue.get());
    }

    @Test
    void RemoveItemOutsideOfBoundsFromPopulatedListReturnsEmptyOption() {
        createListWithOneItem();
        Optional<String> returnedValue = testList.remove(1);
        assertFalse(returnedValue.isPresent());
        assertNull(returnedValue.get());
    }

    @Test
    void InsertThreeItemsThenRemoveFirstItemThreeTimesLeavesListWithNullHeadAndTailAndZeroLength() {
        createListWithThreeItems();
        for (int i = 0; i < 3; i++) {
            testList.remove(0);
        }
        assertNull(testList.head());
        assertNull(testList.tail());
        assertEquals(0, testList.getLength());
        assertTrue(testList.isEmpty());
    }

    @Test
    void InsertThreeItemsThenRemoveLastItemThreeTimesLeavesListWithNullHeadAndTailAndZeroLength() {
        createListWithThreeItems();
        for (int i = 0; i < 3; i++) {
            testList.remove(testList.getLength() - 1);
        }
        assertNull(testList.head());
        assertNull(testList.tail());
        assertEquals(0, testList.getLength());
        assertTrue(testList.isEmpty());
    }

    @Test
    void InsertFourItemsThenRemoveThirdItemLeavesListWithThreeItems() {
        createListWithFourItems();
        testList.remove(2);
        assertEquals(3, testList.getLength());
    }

    @Test
    void appendItemToEmptyListSetsHeadAndTailToNewNodeAndHasLengthOfOne() {
        assertTrue(testList.append("Head And Tail"));
        assertEquals(testList.head(), testList.tail());
        assertEquals("Head And Tail", testList.head().getData());
        assertEquals(1, testList.getLength());
    }

    @Test
    void appendItemToListWithOneItemSetsTailToNewNodeAndHasLengthOfTwo() {
        testList.insert("Head");
        assertTrue(testList.append("Tail"));
        assertEquals("Head", testList.head().getData());
        assertEquals("Tail", testList.tail().getData());
        assertEquals(2, testList.getLength());
    }

    @Test
    void callingPopRearOnEmptyListReturnsEmptyOption() {
        Optional<String> returnedValue = testList.popRear();
        assertInstanceOf(EmptyOption.class, returnedValue);
    }

    @Test
    void callingPopRearOnListWithOneItemSetsHeadAndTailToNull() {
        testList.insert("ThrownOut");
        assertInstanceOf(SomeOption.class, testList.popRear());
        assertNull(testList.head());
        assertNull(testList.tail());
    }
}
