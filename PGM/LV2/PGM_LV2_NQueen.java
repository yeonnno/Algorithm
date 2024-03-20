class Solution {
    
    static int N, answer;
    static int[] map;
    
    public int solution(int n) {
        N = n;
        answer = 0;
        map = new int[N];
        
        backtrack(0);
        
        return answer;
    }
    
    public static void backtrack(int row) {
        if (row == N) {
            answer++;
        } else {
            for (int i = 0; i < N; i++) {
                map[row] = i;
                
                if (isPossible(row)) {
                    backtrack(row + 1);
                }
            }
        }
    }
    
    public static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (map[row] == map[i]) return false;
            else if (Math.abs(map[row] - map[i]) == Math.abs(row - i)) return false;
        }
        
        return true;
    }
}
