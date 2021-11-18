package baekjoon.basic;

import java.io.*;
import java.util.Stack;

/**
 * 에디터
 * https://www.acmicpc.net/problem/1406
 *
 * abcd
 * 3
 * P x
 * L
 * P y
 */
public class Bj1406 {
    public static void main(String[] args) throws IOException {
        solution();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        String characters = br.readLine();
        int firstline = characters.length();
        int i = 0;
        while (firstline-- > 0) {
            left.push(characters.charAt(i++));
        } // left: abcd

        i = Integer.parseInt(br.readLine());

        while (i-- > 0) {
            String s = br.readLine();
            char c = s.charAt(0);
            if (c == 'P') {
                char t = s.charAt(2); // add
                left.push(t);
            }
            else if (c == 'L') {
                if (!left.isEmpty()) right.push(left.pop());
            }
            else if (c == 'D') {
                if (!right.isEmpty()) left.push(right.pop());
            }
            else if (c == 'B') {
                if (!left.isEmpty()) left.pop();
            }
        }
        br.close();
        while (!left.isEmpty()) {
            right.push(left.pop());
        }

        while (!right.isEmpty()) {
            bw.write(right.pop());
        }

        bw.flush();
        bw.close();
    }
}
