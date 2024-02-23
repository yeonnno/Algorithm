import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        char[] arr = new char[len];
        for (int i = 0; i < len; i++) {
            arr[i] = s.charAt(i);
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < len; i++) {
            boolean isFail = false;
            
            for (int j = 0; j < len; j++) {
                char ch = arr[(i + j) % len];
                
                if (ch == '[' || ch == '(' || ch == '{') {
                    stack.push(ch);
                } else {
                    if (ch == ']' && !stack.isEmpty() && stack.pop() == '[') continue;
                    else if (ch == ')' && !stack.isEmpty() && stack.pop() == '(') continue;
                    else if (ch == '}' && !stack.isEmpty() && stack.pop() == '{') continue;
                    
                    isFail = true;
                    break;
                }
            }
            
            if (!isFail && stack.isEmpty()) answer++;
            
            stack.clear();
        }
        
        return answer;
    }
}
