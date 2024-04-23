/**
 * BOJ : 5427 G4 불
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_05427_불 {

    static int N, M, res;
    static char[][] map;
    static Queue<Point> Q, fire;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            map = new char[N][M];
            Q = new LinkedList<>();
            fire = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                String s = br.readLine();
                for (int j = 0; j < M; j++) {
                    map[i][j] = s.charAt(j);

                    if (map[i][j] == '@')
                        Q.offer(new Point(i, j, 0));
                    else if (map[i][j] == '*')
                        fire.offer(new Point(i, j));
                }
            }

            res = 0;
            if (BFS()) sb.append(res).append("\n");
            else sb.append("IMPOSSIBLE\n");
        }

        System.out.print(sb);
    }

    private static boolean BFS() {
        while (!Q.isEmpty()) {
            int fireSize = fire.size();
            for (int i = 0; i < fireSize; i++) {
                Point now = fire.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny)) continue;
                    if (map[nx][ny] == '#' || map[nx][ny] == '*') continue;

                    map[nx][ny] = '*';
                    fire.offer(new Point(nx, ny));
                }
            }

            int qSize = Q.size();
            for (int i = 0; i < qSize; i++) {
                Point now = Q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny)) {
                        res = now.time + 1;
                        return true;
                    }

                    if (map[nx][ny] != '.') continue;

                    map[nx][ny] = '@';
                    Q.offer(new Point(nx, ny, now.time + 1));
                }
            }
        }

        return false;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Point {
        int x;
        int y;
        int time;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
