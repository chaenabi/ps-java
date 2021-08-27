package programmers.codingTestPractice.level2;

import java.util.Stack;

/**
 *
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 * 2021-08-17
 */
public class Pgrs12973 {
    // 효율성 테스트 실패
    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int answer = 0;

        for (int i = 0; i < sb.length();) {
            if (i != sb.length() - 1 && sb.charAt(i) == sb.charAt(i + 1)) {
                sb.deleteCharAt(i).deleteCharAt(i);
                i = 0;
            }
            else {
                i++;
            }
        }
        if (sb.length() == 0) answer = 1;
        return answer;
    }

    // 성공
    public int solution2(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (!stack.empty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            }
            else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.size() < 1) answer = 1;
        return answer;
    }
}
