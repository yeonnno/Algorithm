/**
 * BOJ : 1726 G3 로봇
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01726_로봇 {

    static int N, M, res;
    static int[][] map;
    static int[] start, end;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            start[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        end = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            end[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        res = 0;
        visited = new boolean[4][N][M];

        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        Queue<Robot> Q = new LinkedList<>();
        Q.offer(new Robot(start[0], start[1], start[2], 0));

        visited[start[2]][start[0]][start[1]] = true;

        while (!Q.isEmpty()) {
            Robot now = Q.poll();

            if (now.x == end[0] && now.y == end[1] && now.dir == end[2]) {
                res = now.cnt;
                return;
            }

            // 명령 1 : 현재 방향으로 1~3칸 이동
            for (int i = 1; i <= 3; i++) {
                int nx = now.x + (dx[now.dir] * i);
                int ny = now.y + (dy[now.dir] * i);

                if (!isPossible(nx, ny) || visited[now.dir][nx][ny]) continue;
                if (map[nx][ny] != 0) break;

                visited[now.dir][nx][ny] = true;
                Q.offer(new Robot(nx, ny, now.dir, now.cnt + 1));
            }

            // 명령 2 : 왼쪽 or 오른쪽으로 방향 전환
            for (int d = 0; d < 4; d++) {
                if (now.dir == d || visited[d][now.x][now.y]) continue;

                int turn = 1;
                if (now.dir == 0 && d == 1) turn++;
                else if (now.dir == 1 && d == 0) turn++;
                else if (now.dir == 2 && d == 3) turn++;
                else if (now.dir == 3 && d == 2) turn++;

                visited[d][now.x][now.y] = true;
                Q.offer(new Robot(now.x, now.y, d, now.cnt + turn));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Robot {
        int x;
        int y;
        int dir;
        int cnt;

        public Robot(int x, int y, int dir, int cnt) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cnt = cnt;
        }
    }
}
