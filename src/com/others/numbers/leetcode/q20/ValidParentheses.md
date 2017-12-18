---
title: "Check if given parentheses is balanced."
tags: Leetcode, Others, Easy
---

### Question
Given a string containing just the characters `'(', ')'`, `'{', '}'`, `'[' and ']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

### Links
* [Question link](https://leetcode.com/problems/valid-parentheses/description/)
* [Code](./ValidParentheses.java)
* [Discussion](https://discuss.leetcode.com/category/28/valid-parentheses)

### Notes
* Forgot case where stack is empty by the time I hit closing parenthesis. Ex: `]` input would fail rightaway.

### Code
```java
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
```