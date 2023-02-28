package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class PrefixIntoPostfixTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void simpleAddition() {
        char[] outputString = PrefixIntoPostfix.convertPrefixIntoPostfixFromString("+AB");
        assertArrayEquals("AB+".toCharArray(), outputString);
    }

    @Test
    void simpleMultiplication() {
        char[] outputString = PrefixIntoPostfix.convertPrefixIntoPostfixFromString("*AB");
        assertArrayEquals("AB*".toCharArray(), outputString);
    }

    @Test
    void inputInIncorrectOrderThrowsInputMismatchException() {
        assertThrows(InputMismatchException.class, () -> PrefixIntoPostfix.convertPrefixIntoPostfixFromString("A*B"));
    }

    @Test
    void tooManyOperandsThrowsInputMismatchException() {
        assertThrows(InputMismatchException.class, () -> PrefixIntoPostfix.convertPrefixIntoPostfixFromString("*AAB"));
    }

    @Test
    void tooManyOperatorsThrowsInputMismatchException() {
        assertThrows(InputMismatchException.class, () -> PrefixIntoPostfix.convertPrefixIntoPostfixFromString("AB++"));
    }

    @Test
    void badCharacterInInputThrowsInputMismatchException() {
        assertThrows(InputMismatchException.class, () -> PrefixIntoPostfix.convertPrefixIntoPostfixFromString("+A}"));
    }
}