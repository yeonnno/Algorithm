import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < ingredient.length; i++) {
            stack.push(ingredient[i]);
            
            if (stack.size() < 4) continue;
            
            int four = stack.pop();
            int three = stack.pop();
            int two = stack.pop();
            int one = stack.pop();
            
            if (one == 1 && two == 2 && three == 3 && four == 1) answer++;
            else {
                stack.push(one);
                stack.push(two);
                stack.push(three);
                stack.push(four);
            }
        }
        
        return answer;
    }
}
