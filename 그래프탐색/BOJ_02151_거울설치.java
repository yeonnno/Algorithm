/**
 * BOJ : 2151 G3 거울 설치
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class BOJ_02151_거울설치 {

    static int N, res;
    static char[][] map;
    static ArrayList<Point> door;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        door = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == '#') {
                    map[i][j] = '.';
                    door.add(new Point(i, j));
                }
            }
        }

        res = 0;
        visited = new boolean[4][N][N];

        BFS(door.get(0));

        System.out.println(res);
    }

    private static void BFS(Point p) {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.offer(new Point(p.x, p.y, -1, 0));

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.x == door.get(1).x && now.y == door.get(1).y) {
                res = now.cnt;
                return;
            }

            // 시작점 일 경우
            if (now.dir == -1) {
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny) || map[nx][ny] == '*') continue;

                    visited[d][now.x][now.y] = true;
                    PQ.offer(new Point(nx, ny, d, now.cnt));
                }
                continue;
            }

            // 거울을 설치할 경우
            if (map[now.x][now.y] == '!') {
                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny) || visited[d][nx][ny] || map[nx][ny] == '*') continue;
                    if (now.dir == d || Math.abs(now.dir - d) == 2) continue;

                    visited[d][now.x][now.y] = true;
                    PQ.offer(new Point(nx, ny, d, now.cnt + 1));
                }
            }

            // 거울을 설치할 수 없는 곳이거나 설치하지 않을 경우
            int nx = now.x + dx[now.dir];
            int ny = now.y + dy[now.dir];

            if (!isPossible(nx, ny) || visited[now.dir][nx][ny] || map[nx][ny] == '*') continue;

            visited[now.dir][now.x][now.y] = true;
            PQ.offer(new Point(nx, ny, now.dir, now.cnt));
        }

    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int dir;
        int cnt;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
}
