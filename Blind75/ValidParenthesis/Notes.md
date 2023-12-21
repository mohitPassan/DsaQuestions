# Problem statement

Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

An input string is valid if:

1. Open brackets must be closed by the same type of brackets.
2. Open brackets must be closed in the correct order.
3. Every close bracket has a corresponding open bracket of the same type.

**Example 1:**

**Input:** s = "()"
**Output:** true

**Example 2:**

**Input:** s = "()\[]{}"
**Output:** true

**Example 3:**

**Input:** s = "(]"
**Output:** false

**Constraints:**

- `1 <= s.length <= 104`
- `s` consists of parentheses only `'()[]{}'`.

# Stack

The solution is really simple, just use a stack. Loop through the string and do the following:

1. If any opening bracket is encountered, `push` it in the stack.
2. If any closing bracket is encountered, check if the `top` is the corresponding opening bracket or not
	1. If it is, `pop`.
	2. If it is not, return `false`
3. If in the loop, stack gets empty, this means that there are no opening brackets for the amount of closing ones, so return `false`.

In the end, if the stack is empty, return `true`, else return `false`.

## Code

```java
class Solution {
    public boolean isValid(String s) {
        char[] sc = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        if(sc[0] == ')' || sc[0] == '}' || sc[0] == ']') {
            return false;
        }

        for(char c : sc) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if(stack.empty()) {
                    return false;
                }

                char toCheck = stack.peek();

                if(c == ')' && toCheck == '(') {
                    stack.pop();
                } else if(c == '}' && toCheck == '{') {
                    stack.pop();
                } else if(c == ']' && toCheck == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}
```