package com.others.numbers.leetcode.q9;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class PalindromeNumberTest {
    private PalindromeNumber obj = new PalindromeNumber();

    @Test
    public void test_zero() {
        assertTrue(obj.isPalindrome(0));
    }

    @Test
    public void test_101() {
        assertTrue(obj.isPalindrome(101));
    }
}
