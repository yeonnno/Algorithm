class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;
        for (int station : stations) {
            int end = station - w;
            if (start < end) {
                answer += (end - start) / (w + w + 1);
                
                if ((end - start) % (w + w + 1) != 0)
                    answer++;
            }
            
            start = station + w + 1;
        }
        
        if (start <= n) {
            int end = n + 1;
            
            answer += (end - start) / (w + w + 1);
            
            if ((end - start) % (w + w + 1) != 0)
                answer++;
        }

        return answer;
    }
}
