package com.others.numbers.leetcode.q20;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidParentheseTest {
    private ValidParentheses obj = new ValidParentheses();

    @Test
    public void test_valid() {
        assertTrue(obj.isValid("()"));
        assertTrue(obj.isValid("[]"));
        assertTrue(obj.isValid("{}"));
        assertTrue(obj.isValid("[{{()()}}]"));
    }
}
