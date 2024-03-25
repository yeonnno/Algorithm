class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int val = s / n;
        int remain = s % n;
        
        if (val == 0) return new int[] {-1};
        
        
        for (int i = 0; i < n; i++) {
            answer[i] = val;
        }
        
        int idx = n - 1;
        for (int i = 0; i < remain; i++) {
            answer[idx--]++;
        }
        
        return answer;
    }
}
