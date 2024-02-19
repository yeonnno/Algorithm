class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            int tmp = 0;
            
            for (int j = i; j <= n; j++) {
                tmp += j;
                
                if (tmp >= n) break;
            }
            
            if (tmp == n) answer++;
        }
        
        return answer;
    }
}
