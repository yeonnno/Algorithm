import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int work : works) {
            PQ.offer(work);
        }
        
        for (int i = 0; i < n; i++) {
            if (PQ.isEmpty()) break;
            
            int work = PQ.poll() - 1;
            
            if (work == 0) continue;
            
            PQ.offer(work);
        }
        
        while (!PQ.isEmpty()) {
            answer += Math.pow(PQ.poll(), 2);
        }
        
        return answer;
    }
}
