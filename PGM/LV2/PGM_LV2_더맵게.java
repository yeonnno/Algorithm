import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int sco : scoville) {
            PQ.offer(sco);
        }
        
        while (true) {
            if (PQ.peek() >= K || PQ.size() < 2) break;
            
            int mix = PQ.poll() + PQ.poll() * 2;
            PQ.offer(mix);
            answer++;
        }
        
        if (PQ.peek() < K && PQ.size() < 2) return -1;
        else return answer;
    }
}
