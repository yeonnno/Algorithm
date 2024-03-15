import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long total = 1;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
            total *= i;
        }
        
        k--;
        int idx = 0;
        while (idx < n) {
            total /= n - idx;
            
            int val = (int) (k / total);
            answer[idx] = list.get(val);
            list.remove(val);
            
            k %= total;
            idx++;
        }
        
        return answer;
    }
}
