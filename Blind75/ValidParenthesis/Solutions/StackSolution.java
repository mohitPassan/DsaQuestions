package Blind75.ValidParenthesis.Solutions;

import java.util.Stack;

public class StackSolution implements ISolution {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        if (sc[0] == ')' || sc[0] == '}' || sc[0] == ']') {
            return false;
        }

        for (char c : sc) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }

                char toCheck = stack.peek();

                if (c == ')' && toCheck == '(') {
                    stack.pop();
                } else if (c == '}' && toCheck == '{') {
                    stack.pop();
                } else if (c == ']' && toCheck == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
