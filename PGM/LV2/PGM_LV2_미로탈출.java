import java.util.*;

class Solution {
    static int N, M;
    static final int INF = 999999;
    static char[][] map;
    static int[] start, end, lever;
    static int[][] dist1, dist2;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int solution(String[] maps) {
        N = maps.length; M = maps[0].length();
        map = new char[maps.length][maps[0].length()];
        start = new int[2]; end = new int[2]; lever = new int[2];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = maps[i].charAt(j);
                if (map[i][j] == 'S') {
                    start[0] = i; start[1] = j; map[i][j] = 'O';
                } else if (map[i][j] == 'E') {
                    end[0] = i; end[1] = j; map[i][j] = 'O';
                } else if (map[i][j] == 'L') {
                    lever[0] = i; lever[1] = j; map[i][j] = 'O';
                }
            }
        }
        
        dist1 = new int[N][M];
        dist2 = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist1[i], INF);
            Arrays.fill(dist2[i], INF);
        }
        
        dijkstra(start, lever, dist1);
        dijkstra(lever, end, dist2);
        
        int answer = dist1[lever[0]][lever[1]] + dist2[end[0]][end[1]];
        
        return answer >= INF ? -1 : answer;
    }
    
    public static void dijkstra(int[] s, int[] e, int[][] dist) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(s[0], s[1]));
        dist[s[0]][s[1]] = 0;
        
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            
            if (now.x == e[0] && now.y == e[1]) return;
            
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] != 'O') continue;
                
                if (dist[nx][ny] > dist[now.x][now.y] + 1) {
                    dist[nx][ny] = dist[now.x][now.y] + 1;
                    Q.offer(new Point(nx, ny));
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
