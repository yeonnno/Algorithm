class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        
        int[] count = new int[201];
        for (int[] line : lines) {
            for (int i = line[0]+100; i < line[1]+100; i++) {
                count[i]++;
            }
        }
        
        for (int i = 0; i < 201; i++) {
            if (count[i] >= 2) answer++;
        }
        
        return answer;
    }
}
