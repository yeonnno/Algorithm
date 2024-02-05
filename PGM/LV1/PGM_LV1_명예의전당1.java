import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int len = score.length;
        int[] answer = new int[len];
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        
        for (int i = 0; i < len; i++) {
            PQ.add(score[i]);
            
            if (i >= k) PQ.poll();
            
            answer[i] = PQ.peek();
        }
        
        return answer;
    }
}
