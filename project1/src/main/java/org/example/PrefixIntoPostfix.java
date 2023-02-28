package org.example;

import java.io.*;
import java.util.InputMismatchException;

public class PrefixIntoPostfix {
    private final LinkedListStack<char[]> dataStack;
    private final LinkedListStack<Character> prefixStack;
    private final char[] operators = {'+', '-', '*', '/', '$'};

    private PrefixIntoPostfix (String prefixExpression) throws InputMismatchException{
        this();
        for (Character i : prefixExpression.toCharArray()) {
            this.prefixStack.push(i);
        }
    }

    private PrefixIntoPostfix() {
        this.dataStack = new LinkedListStack<>();
        this.prefixStack = new LinkedListStack<>();
    }

    public static void convertPrefixIntoPostfixFromFile(String inputFilename, String outputFilename)
                throws IOException, InputMismatchException{
        PrefixIntoPostfix prefixIntoPostfix = new PrefixIntoPostfix();
        prefixIntoPostfix.handleConversion(inputFilename, outputFilename);
    }

    public static char[] convertPrefixIntoPostfixFromString(String prefixExpression) {
        PrefixIntoPostfix prefixIntoPostfix = new PrefixIntoPostfix(prefixExpression);
        return prefixIntoPostfix.convert();
    }

    public void handleConversion (String inputFilename, String outputFileName) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(inputFilename);
            outputStream = new FileOutputStream(outputFileName);

            int c = inputStream.read();
            while (c != -1) {
                while(c != '\n' && c != -1) {
                    prefixStack.push((char) c);
                    c = inputStream.read();
                }
                if (c != -1 && !prefixStack.isEmpty()) { //checks for EOF as well as handles empty line
                    try{
                        for (char i: this.convert()) {
                            outputStream.write(i);
                        }
                    } catch (Exception e) {
                        char[] errorLine = {'i', 'n', 'v', 'a', 'l', 'i', 'd', ' ', 'i', 'n', 'p', 'u', 't', ',',
                                                's', 'e', 'e', ' ', 'c', 'o', 'n', 's', 'o', 'l', 'e', ' ', 'o',
                                                'u', 't', 'p', 'u', 't', '.'};
                        for (char i: errorLine) {
                            outputStream.write(i);
                        }

                    }
                    outputStream.write('\n');
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("The file specified could not be found");
        } catch (IOException e) {
            System.out.println("There was an error when reading the file");
        }
        finally{
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("There was an issue when closing the input file.");
                }
            }
            if (outputStream != null) {

                try {
                    outputStream.close();
                } catch (IOException e) {
                    System.out.println("There was an issue closing the output file.");
                }
            }
        }
    }

    public char[] convert() {
        outerLoop:
        while (!prefixStack.isEmpty()){
            char i = prefixStack.pop().get();
            for (char j: operators) {
                if (i == j) {
                    handleOperation(i);
                    continue outerLoop;
                }
            }
            if ((i >= 'a' && i <= 'z') || (i >= 'A' && i <= 'Z')) {
                dataStack.push(new char[]{i});
            }
            else {
                throw new InputMismatchException("There is an invalid character in the input");
            }
        }
        if (dataStack.length() == 1) {
            return dataStack.pop().get();
        }
        else {
            throw new InputMismatchException("The input expression was not valid.");
        }
    }

    private void handleOperation(char i) {
        Optional<char[]> firstOperand = dataStack.pop();
        Optional<char[]> secondOperand = dataStack.pop();
        if (firstOperand.isPresent() && secondOperand.isPresent()) {
            char[] combinedExpression = new char[firstOperand.get().length
                    + secondOperand.get().length + 1];
            int cursor = 0;
            for (char c : firstOperand.get()) {
                combinedExpression[cursor++] = c;
            }
            for (char c : secondOperand.get()) {
                combinedExpression[cursor++] = c;
            }
            combinedExpression[cursor] = i;
            assert (cursor == combinedExpression.length - 1) : "Size Mismatch in combination logic";
            dataStack.push(combinedExpression);
        } else {
            throw new InputMismatchException("Expression is malformed. Not enough operands at this point.");
        }
    }
}
