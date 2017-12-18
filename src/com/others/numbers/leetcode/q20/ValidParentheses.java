package com.others.numbers.leetcode.q20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    // Use ImmutableMap if provided.
    private static final Map<Character, Character> MAPPING = new HashMap<>();
    static {
        MAPPING.put(')', '(');
        MAPPING.put(']', '[');
        MAPPING.put('}', '{');
    };

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (MAPPING.values().contains(c)) {
                stack.push(c);
            } else if (MAPPING.containsKey(c)) {
                if (stack.isEmpty() || !stack.pop().equals(MAPPING.get(c))) {
                    return false;
                }
            }
            // Skip if not parenthesis.
        }
        return stack.isEmpty();
    }
}
