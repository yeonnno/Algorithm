import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';
            
            if (alpha[idx] == -1) {
                answer[i] = -1;
                alpha[idx] = i;
            } else {
                answer[i] = i - alpha[idx];
                alpha[idx] = i;
            }
        }
        
        return answer;
    }
}
