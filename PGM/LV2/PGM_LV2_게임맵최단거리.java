import java.util.*;

class Solution {
    
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] dist;
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        dist = new int[N][M];
        
        BFS(maps);
        
        return dist[N - 1][M - 1] == 0 ? -1 : dist[N - 1][M - 1];
    }
    
    public static void BFS(int[][] map) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(0, 0));
        dist[0][0] = 1;
        
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if (!isPossible(nx, ny)) continue;
                
                if (dist[nx][ny] == 0 && map[nx][ny] == 1) {
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    Q.add(new Point(nx, ny));
                }
            }
        }
    }
    
    public static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
    
    public static class Point {
        int x;
        int y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
