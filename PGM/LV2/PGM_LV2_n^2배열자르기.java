class Solution {
    public int[] solution(int n, long left, long right) {
        int len = (int) (right - left + 1);
        int[] answer = new int[len];
        
        int idx = 0;
        for (long i = left; i <= right; i++) {
            answer[idx++] = Math.max((int)(i / n), (int)(i % n)) + 1;
        }
        
        return answer;
    }
}
