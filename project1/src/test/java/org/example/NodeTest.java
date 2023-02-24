package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
    Node<String> testNode;
    @BeforeEach
    void setUp() {
        testNode = new Node<>("TestData");
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    void getData() {
        assertEquals("TestData", testNode.getData());
    }

    @Test
    void setNextAndGetNext() {
        Node<String> nextNode = new Node<>("NextData");
        testNode.setNext(nextNode);
        assertEquals(nextNode, testNode.getNext());
    }

    @Test
    void unlink() {
        Node<String> nextNode = new Node<>("NextData");
        testNode.setNext(nextNode);
        testNode.unlink();
        assertNull(testNode.getNext());
    }

    @Test
    void unwrapData() {
        String temp = testNode.unwrapData();
        assertEquals(temp, testNode.getData());
    }
}