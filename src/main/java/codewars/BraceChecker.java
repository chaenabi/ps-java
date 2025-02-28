package codewars;

import java.util.Stack;

public class BraceChecker {

    public boolean isValid(String braces) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < braces.length(); i++) {
            switch (braces.charAt(i)) {
                case '(' , '{' , '[' -> stack.add(braces.charAt(i));
                case ')' -> {
                    if (stack.isEmpty() || !stack.pop().equals('(')) return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || !stack.pop().equals('[')) return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || !stack.pop().equals('{')) return false;
                }
            }
        }
        return stack.isEmpty();
    }

}