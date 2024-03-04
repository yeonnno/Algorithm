import java.util.*;

class Solution {
    public int solution(int[] order) {
        int idx = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < order.length; i++) {
            stack.push(i + 1);
            
            while (!stack.isEmpty()) {
                if (order[idx] == stack.peek()) {
                    stack.pop();
                    idx++;
                } else break;
            }
        }
        
        return idx;
    }
}
