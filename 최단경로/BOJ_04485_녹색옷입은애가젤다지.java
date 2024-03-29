/**
 * BOJ : 4485 G4 녹색 옷 입은 애가 젤다지
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_04485_녹색옷입은애가젤다지 {

    static int N, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int tc = 0;
        while (true) {
            tc++;
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            visited = new boolean[N][N];
            visited[0][0] = true;

            dijkstra();

            sb.append("Problem ").append(tc).append(": ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static void dijkstra() {
        PriorityQueue<Point> PQ = new PriorityQueue();
        PQ.add(new Point(0, 0, map[0][0]));

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                res = now.cost;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                PQ.add(new Point(nx, ny, now.cost + map[nx][ny]));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int cost;

        Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Point o) {
            return this.cost - o.cost;
        }
    }
}
