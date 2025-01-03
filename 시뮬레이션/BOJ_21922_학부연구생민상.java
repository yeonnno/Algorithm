/**
 * BOJ : 21922 G5 학부 연구생 민상
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21922_학부연구생민상 {

    static int N, M, res;
    static int[][] map;
    static boolean[][][] visited;
    static Queue<Point> Q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][4];
        Q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    for (int d = 0; d < 4; d++) {
                        Q.offer(new Point(i, j, d));
                        visited[i][j][d] = true;
                    }
                }
            }
        }

        BFS();

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isVisited(i, j))
                    res++;
            }
        }

        System.out.println(res);
    }

    private static boolean isVisited(int x, int y) {
        for (int d = 0; d < 4; d++) {
            if (visited[x][y][d])
                return true;
        }
        return false;
    }

    private static void BFS() {
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            int nx = now.x + dx[now.dir];
            int ny = now.y + dy[now.dir];

            if (!isPossible(nx, ny) || visited[nx][ny][now.dir]) continue;

            visited[nx][ny][now.dir] = true;

            switch (map[nx][ny]) {
                case 0:
                    Q.offer(new Point(nx, ny, now.dir));
                    break;
                case 1:
                    Q.offer(new Point(nx, ny, now.dir % 2 == 0 ? now.dir : (now.dir + 2) % 4));
                    break;
                case 2:
                    Q.offer(new Point(nx, ny, now.dir % 2 == 1 ? now.dir : (now.dir + 2) % 4));
                    break;
                case 3:
                    Q.offer(new Point(nx, ny, convert(now.dir, true)));
                    break;
                case 4:
                    Q.offer(new Point(nx, ny, convert(now.dir, false)));
                    break;
            }
        }
    }

    private static int convert(int now, boolean shape) {
        switch (now) {
            case 0:
                return shape ? 1 : 3;
            case 1:
                return shape ? 0 : 2;
            case 2:
                return shape ? 3 : 1;
            case 3:
                return shape ? 2 : 0;
        }

        return -1;
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class Point {
        int x;
        int y;
        int dir;

        public Point(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
}
