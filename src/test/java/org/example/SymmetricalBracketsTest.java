package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SymmetricalBracketsTest {

    @ParameterizedTest(name = "Test {index} => testing value=''{0}''")
    @ValueSource(strings = {
            "",
            "{}()[]",
            "(())",
            "{{}}[[]]",
            "{{[]()}}",
            "([{{[(())]}}])"
    })
    public void testPositiveCases(String value) {
        Assertions.assertTrue(SymmetricalBrackets.isStingSymmetrical(value));
    }

    @ParameterizedTest(name = "Test {index} => testing value=''{0}''")
    @ValueSource(strings = {
            "{aa}",
            "{}()[]b",
            "bbb{}()[]b",
            "[[]",
            "[",
            "(",
            "())}",
            "((())",
            "))((",
            ")(()",
            "())(",
            "{[(])}",
            "{{[]()}}}}"
    })
    public void testNegativeCases(String value) {
        Assertions.assertFalse(SymmetricalBrackets.isStingSymmetrical(value));
    }

    @Test
    public void testMainWithNull() {
        SymmetricalBrackets.main(null);
    }

    @Test
    public void testMainWithString() {
        SymmetricalBrackets.main(new String[]{"())"});
    }

}