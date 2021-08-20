package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 * created: 2021-07-30
 */
public class Leet22 {
    private List<String> answer;
    private int max;
    public List<String> generateParenthesis(int n) {
        answer = new ArrayList<>();
        if (n == 1) return List.of("()");
        max = n;
        cal(0, 0, "");
        return (answer);
    }

    private void cal(int open, int close, String str) {
        if (str.length() == max * 2) {
            answer.add(str);
            return;
        }

        if (open < max) cal(open + 1, close, str + "(");
        if (close < open) cal(open, close + 1, str + ")");
    }
}