class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1;
        
        int num = section[0];
        for (int sect : section) {
            if (num + m - 1 < sect) {
                answer++;
                num = sect;
            }
        }
        
        return answer;
    }
}
