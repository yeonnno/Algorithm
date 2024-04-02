import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        PriorityQueue<int[]> PQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        
        int jobIdx = 0;
        int cnt = 0;
        int end = 0;
        while (cnt < jobs.length) {
            
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= end) {
                PQ.offer(jobs[jobIdx++]);
            }
            
            if (PQ.isEmpty()) {
                end = jobs[jobIdx][0];
            } else {
                int[] job = PQ.poll();
                answer += end + job[1] - job[0];
                end += job[1];
                cnt++;
            }
        }

        return answer / jobs.length;
    }
}
