import java.util.*;

class Solution {
    static int N, M;
    static char[][] map;
    static int[] start, end;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        start = new int[2];
        end = new int[2];
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = board[i].charAt(j);
                
                if (map[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                } else if (map[i][j] == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }
        
        visited = new boolean[N][M];
        
        int answer = BFS();
        
        return answer;
    }
    
    public static int BFS() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            
            if (now.x == end[0] && now.y == end[1])
                return now.cnt;
            
            for (int d = 0; d < 4; d++) {
                int nx = now.x;
                int ny = now.y;
                
                while (true) {
                    nx += dx[d];
                    ny += dy[d];
                    
                    if (!isPossible(nx, ny) || map[nx][ny] == 'D') break;
                }
                
                nx -= dx[d];
                ny -= dy[d];
                
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny, now.cnt + 1));
            }
        }
        
        return -1;
    }
    
    public static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
    
    public static class Point {
        int x;
        int y;
        int cnt;
        
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
