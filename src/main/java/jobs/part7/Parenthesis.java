package jobs.part7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Parenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        br.close();
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                    stack.add('(');
                    break;
                case ')':
                    if (!stack.isEmpty()) stack.pop();
                    else {
                        System.out.println("NO");
                        return;
                    }
            }
        }
        if (stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
    }
}
