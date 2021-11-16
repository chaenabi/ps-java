package baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 괄호
 * www.acmicpc.net/problem/9012
 * 2021-11-15
 */
public class Bj9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> tokens = new LinkedList<>();

        int count = Integer.parseInt(br.readLine()); // 6

        while (count-- > 0) {
            tokens.offer(br.readLine());
        }
        br.close();

        while (!tokens.isEmpty()) {
            Stack<Character> openPth = new Stack<>();

            String token = tokens.poll();
            char[] chars = new char[token.length()];
            for (int i = 0; i < token.length(); i++) {
                chars[i] = token.charAt(i); // ( ( ( (//4 )//3 (//4 )//3 )//2 (//1 )//0
            }

            boolean flag = false;

            // 메인로직: ( 이면, 스택에 넣고, ) 스택에서 pop.
            // 스택이 비어있는데 ) 이면 NO 출력
            for (char aChar : chars) {
                if (aChar == '(') {
                    openPth.push(aChar);
                } else {
                    if (!openPth.empty()) openPth.pop();
                    else {
                        flag = true;
                        break;
                    }
                }
            }
            if (flag) System.out.println("NO");
            else if (openPth.empty()) System.out.println("YES");
            else if (!openPth.empty()) System.out.println("NO");
        }
    }
}






















