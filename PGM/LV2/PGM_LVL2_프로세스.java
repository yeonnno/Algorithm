import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Integer> Q = new LinkedList<>();
        for (int priority : priorities) 
            Q.add(priority);
        
        Arrays.sort(priorities);
        int idx = priorities.length - 1;
        
        while (!Q.isEmpty()) {
            int now = Q.poll();
            
            if (location == 0) {
                if (now == priorities[idx]) break;
                else {
                    Q.add(now);
                    location = Q.size() - 1;
                }
            } else {
                if (now == priorities[idx]) {
                    answer++;
                    idx--;
                } else {
                    Q.add(now);
                }
                    location--;
            }
        }
        
        return answer;
    }
}
