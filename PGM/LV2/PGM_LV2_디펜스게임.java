import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        int i = 0;
        for (i = 0; i < enemy.length; i++) {
            PQ.offer(enemy[i]);
            n -= enemy[i];
            
            if (n < 0) {
                if (k > 0) {
                    n += PQ.poll();
                    k--;
                } else {
                    break;
                }
            }
        }
        answer = i;
        
        return answer;
    }
}
