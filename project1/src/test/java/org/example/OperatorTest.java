package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    //@ParameterizedTest TODO: Make Parameterized
    @Test
    void getOperatorType() {
        assertEquals(Operator.OperatorType.ADD, new Operator('+').getOperatorType());
        assertEquals(Operator.OperatorType.SUBTRACT, new Operator('-').getOperatorType());
        assertEquals(Operator.OperatorType.MULTIPLY, new Operator('*').getOperatorType());
        assertEquals(Operator.OperatorType.DIVIDE, new Operator('/').getOperatorType());
        assertEquals(Operator.OperatorType.EXPONENT, new Operator('$').getOperatorType());
    }

    @Test
    void subtractAndAdditionAreEquivalent() {
        assertEquals(0, new Operator('-').compareTo(new Operator('+')));
    }

    @Test
    void MultiplyAndDivideAreEquivalent() {
        assertEquals(0, new Operator('*').compareTo(new Operator('/')));
    }

    @Test
    void additionIsLessThanMultiplication() {
        assertEquals(-1, new Operator('+').compareTo(new Operator('*')));
    }

    @Test
    void multiplicationIsLessThanExponentiation() {
        assertEquals(-1, new Operator('*').compareTo(new Operator('$')));
    }

    @Test
    void exponentiationIsGreaterThanAddition() {
        assertEquals(1, new Operator('$').compareTo(new Operator('+')));
    }
}