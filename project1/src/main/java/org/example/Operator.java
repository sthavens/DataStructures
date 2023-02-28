package org.example;


import java.security.InvalidParameterException;

public class Operator implements Comparable<Operator>{
    public enum OperatorType{
        ADD,
        SUBTRACT,
        MULTIPLY,
        DIVIDE,
        EXPONENT
    }

    private final OperatorType operator;

    public Operator(char operator) {
        this.operator = switch(operator) {
            case '+' -> OperatorType.ADD;
            case '-' -> OperatorType.SUBTRACT;
            case '*' -> OperatorType.MULTIPLY;
            case '/' -> OperatorType.DIVIDE;
            case '$' -> OperatorType.EXPONENT;
            default -> throw new InvalidParameterException("Non-Operator Passed");
        };
    }

    public OperatorType getOperatorType() {
        return operator;
    }

    private static int getPriority(OperatorType op) {
        return switch (op) {
            case ADD, SUBTRACT -> 0;
            case MULTIPLY, DIVIDE -> 1;
            case EXPONENT -> 2;
        };
    }

    @Override
    public int compareTo(Operator other) {
        return compare(getPriority(operator), getPriority(other.getOperatorType()));
    }

    public static int compare(int x, int y) {
        return (x < y) ? -1 : ((x == y) ? 0 : 1);
    }
}
