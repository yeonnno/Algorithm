import java.util.*;

class Solution {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'X') map[i][j] = 0;
                else map[i][j] = maps[i].charAt(j) - '0';
            }
        }
        
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 0) continue;
                
                PQ.offer(bfs(i, j));
            }
        }
        
        int size = PQ.size();
        if (size == 0) {
            return new int[]{-1};
        } else {
            int[] answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = PQ.poll();
            }
            
            return answer;
        }
    }
    
    public static int bfs(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(x, y));
        visited[x][y] = true;
        int sum = 0;
        
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            
            sum += map[now.x][now.y];
            
            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];
                
                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                Q.offer(new Point(nx, ny));
            }
        }
        
        return sum;
    }
    
    public static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < n && ny >= 0 && ny < m) return true;
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
