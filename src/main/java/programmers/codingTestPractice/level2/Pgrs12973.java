package programmers.codingTestPractice.level2;

import java.util.Stack;

/**
 *
 * 짝지어 제거하기
 * https://programmers.co.kr/learn/courses/30/lessons/12973
 * 2021-08-17
 */
public class Pgrs12973 {

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

    public int solution2(String s) {
        String[] arr = s.split("");
        Stack<String> stack = new Stack<>();
        int answer = 0;

        if (arr.length > 1) stack.push(arr[0]);

        for (int i = 1; !stack.empty(); i++) {
            if (i == arr.length - 1) break;

            if (stack.peek().equals(arr[i])) {
                stack.pop();
            }
            else {
                stack.push(arr[i]);
            }
        }
        if (stack.size() < 1) answer = 1;
        return answer;
    }
}
