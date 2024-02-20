import java.util.*;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) stack.pop();
            else stack.push(ch);
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
