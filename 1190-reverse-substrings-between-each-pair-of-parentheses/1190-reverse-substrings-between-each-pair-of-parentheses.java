import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(new StringBuilder());
            } else if (ch == ')') {
                StringBuilder top = stack.pop().reverse();
                stack.peek().append(top);
            } else {
                stack.peek().append(ch);
            }
        }

        return stack.peek().toString();
    }
}