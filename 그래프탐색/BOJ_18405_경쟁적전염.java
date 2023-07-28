/**
 * BOJ : 18405 G5 경쟁적 전염
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_18405_경쟁적전염 {

    static int N, K, S, X, Y;
    static int[][] map;
    static PriorityQueue<Point> PQ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    PQ.add(new Point(i, j, map[i][j], 0));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        Y = Integer.parseInt(st.nextToken()) - 1;

        BFS();

        System.out.println(map[X][Y]);
    }

    private static void BFS() {
        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.time == S) break;
            if (map[X][Y] != 0) break;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] != 0) continue;

                map[nx][ny] = now.virus;
                PQ.add(new Point(nx, ny, now.virus, now.time + 1));
            }

        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int virus;
        int time;

        Point(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }

        @Override
        public int compareTo(Point o) {
            if (this.time != o.time)
                return time - o.time;
            else
                return virus - o.virus;
        }
    }
}
