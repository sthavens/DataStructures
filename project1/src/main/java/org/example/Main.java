package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Argument Length: " + args.length);
            System.out.println("Invalid Number of Arguments");
            return;
        }
        try {
            PrefixIntoPostfix.convertPrefixIntoPostfixFromFile(args[0], args[1]);
        } catch (FileNotFoundException e) {
            System.out.println("File not found, error text: " + e);
        } catch (IOException e) {
            System.out.println("An IO exception was detected, error text: " + e);
        }

    }
}