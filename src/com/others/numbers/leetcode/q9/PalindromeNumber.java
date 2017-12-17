package com.others.numbers.leetcode.q9;

public class PalindromeNumber {
    public boolean isPalindrome(int num) {
        int input = num;
        int reverse = 0;
        // With num >= 10, loop becomes simpler.
        while (num >= 10) {
            int unit = num % 10;
            num = num/10;
            reverse = reverse * 10 + unit;
        }
        reverse = reverse * 10 + num;
        return (input == reverse);
    }
}
