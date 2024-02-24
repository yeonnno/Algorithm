import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int len = citations.length;
        
        Arrays.sort(citations);
        
        for (int i = len; i >= 0; i--) {
            int cnt = 0;
            
            for (int j = len - 1; j >= 0; j--) {
                if (i <= citations[j]) cnt++;
                else break;
            }
            
            if (cnt >= i && len - cnt <= i) return i;
        }
        
        return 0;
    }
}
