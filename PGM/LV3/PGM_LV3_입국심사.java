import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for (int time : times) {
            max = Math.max(max, time);
        }
        
        Arrays.sort(times);
        
        long answer = Long.MAX_VALUE;
        long left = 0, right = max * n;
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int time : times) {
                long cnt = mid / time;
                
                if (sum >= n) break;
                
                sum += cnt;
            }
            
            if (sum >= n) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
