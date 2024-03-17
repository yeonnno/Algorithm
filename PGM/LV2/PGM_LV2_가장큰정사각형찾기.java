class Solution {
    public int solution(int [][]board) {
        int[][] map = new int[board.length + 1][board[0].length + 1];
        int max = 0;
        
        for (int i = 1; i <= board.length; i++) {
            for (int j = 1; j <= board[0].length; j++) {
                if (board[i - 1][j - 1] == 0) continue;
                
                int min = Math.min(map[i - 1][j - 1], Math.min(map[i][j - 1], map[i - 1][j]));
                
                map[i][j] = min + 1;
                
                max = Math.max(max, map[i][j]);
            }
        }

        return max * max;
    }
}
