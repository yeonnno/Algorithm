/**
 * BOJ : 6087 G3 레이저 통신
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_06087_레이저통신 {

    static int N, M, res;
    static final int INF = Integer.MAX_VALUE;
    static char[][] map;
    static ArrayList<Point> startEnd;
    static int[][][] dist;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        startEnd = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'C') {
                    map[i][j] = '.';
                    startEnd.add(new Point(i, j));
                }
            }
        }

        res = INF;
        dist = new int[4][N][M];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.offer(new Point(startEnd.get(0).x, startEnd.get(0).y, 7, -1));

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.x == startEnd.get(1).x && now.y == startEnd.get(1).y) {
                res = Math.min(res, now.cnt);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || map[nx][ny] != '.') continue;
                if (Math.abs(now.dir - d) == 2) continue;

                int next = (now.dir == d) ? now.cnt : now.cnt + 1;
                if (dist[d][nx][ny] > next) {
                    dist[d][nx][ny] = next;
                    PQ.offer(new Point(nx, ny, d, next));
                }
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
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
