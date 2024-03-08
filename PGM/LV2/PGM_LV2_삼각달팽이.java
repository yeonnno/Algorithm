class Solution {
    
    static int[] dx = {1, 0, -1};
    static int[] dy = {0, 1, -1};
    
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int[][] map = new int[n][n];
        
        int d = 0, x = 0, y = 0;
        
        map[x][y] = 1;
        for (int i = 2; i <= n*(n+1)/2; i++) {
            x += dx[d];
            y += dy[d];
            
            map[x][y] = i;
            
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (isPossible(nx, ny, n) && map[nx][ny] == 0) continue;
            
            d = (d+1) % 3;
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) break;
                
                answer[idx++] = map[i][j];
            }
        }
        
        return answer;
    }
    
    public static boolean isPossible(int nx, int ny, int n) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < n) return true;
        else return false;
    }
}
