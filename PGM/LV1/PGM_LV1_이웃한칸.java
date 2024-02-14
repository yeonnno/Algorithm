class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int N = board.length;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        String color = board[h][w];
        
        for (int d = 0; d < 4; d++) {
            int nx = h + dx[d];
            int ny = w + dy[d];
            
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
            
            if (color.equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
}
