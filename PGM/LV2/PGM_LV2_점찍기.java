class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dd = (long) d * d;
        
        for (int i = 0; i <= d; i += k) {
            long ii = (long) i * i;
            answer += (int) Math.sqrt(dd - ii) / k + 1;
        }
        
        return answer;
    }
}
