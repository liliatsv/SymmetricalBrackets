package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SymmetricalBrackets {

    private static final Map<Character, Character> bracketPairs =
            Map.of(
                    ')', '(',
                    '}', '{',
                    ']', '['
            );

    public static boolean isStingSymmetrical(String str) {
        if (str == null || str.length() % 2 != 0) {
            return false;
        }

        List<String> traversed = new ArrayList<>();
        Character[] charList = str.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        for (Character c : charList) {
            if (bracketPairs.containsValue(c)) {
                traversed.add(c.toString());
            } else if (bracketPairs.containsKey(c)) {
                if (traversed.isEmpty() || !isClosingBracket(c, traversed)) {
                    System.out.println("Bracket " + c + " does not have a pair");
                    return false;
                }
                traversed.remove(traversed.size() - 1);
            } else {
                System.out.println("String has illegal character: " + c);
                return false;
            }
        }

        return traversed.isEmpty();
    }

    private static boolean isClosingBracket(Character c, List<String> traversed) {
        return traversed.get(traversed.size() - 1).equals(bracketPairs.get(c).toString());
    }

    public static void main(String[] args) {
        if (args == null || args.length == 0) {
            System.err.println("Error: No input parameter.");
            System.out.println("Usage: java -cp .\\traverseString-1.0-SNAPSHOT.jar org.example.SymmetricalBrackets \"[string to test]\"");
            return;
        }

        for (String arg: args) {
            boolean stingSymmetrical = isStingSymmetrical(arg);
            System.out.printf("The string %s is %s%n", arg, stingSymmetrical ? "symmetrical" : "NOT symmetrical");
        }
    }
}