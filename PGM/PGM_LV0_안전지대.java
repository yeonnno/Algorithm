class Solution {
    static int N;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    check(i, j, board);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0) answer++;
            }
        }
        
        return answer;
    }
    
    public static void check(int x, int y, int[][] board) {
        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            if (board[nx][ny] == 0) board[nx][ny] = 2;
        }
    }
}
