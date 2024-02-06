import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        int idx = score.length % m;
        for (int i = idx; i < score.length; i += m) {
            answer += score[i] * m;
        }
        
        return answer;
    }
}
