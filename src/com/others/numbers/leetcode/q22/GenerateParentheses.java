package com.others.numbers.leetcode.q22;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> parens = new ArrayList<>();
        generateParenthesis(new StringBuilder("("), 1, n*2, parens);
        return parens;
    }

    private void generateParenthesis(final StringBuilder sb, int pendingOpenParens, final int maxLen,
            final List<String> outputList) {
        if (sb.length() == maxLen && pendingOpenParens == 0) {
            // We have string that has balanced parens and of required len.
            outputList.add(sb.toString());
            return;
        }
        if (pendingOpenParens < 0 || pendingOpenParens > maxLen/2 || sb.length() > maxLen ) {
            // We have more closing paren than open - this would be invalid, stop. 
            return;
        }
        // Go on path with "(".
        generateParenthesis(sb.append("("), pendingOpenParens + 1, maxLen, outputList);
        sb.setLength(sb.length() - 1);  // trim last char that we had added.
        generateParenthesis(sb.append(")"), pendingOpenParens - 1, maxLen, outputList);
        sb.setLength(sb.length() - 1);
    }
}
