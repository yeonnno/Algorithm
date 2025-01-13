/**
 * BOJ : 16236 G3 아기 상어
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16236_아기상어 {

    static int N, sharkX, sharkY, size, time, eatCnt, res;
    static final int INF = Integer.MAX_VALUE;
    static int[][] map;
    static boolean isEnd;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    sharkX = i;
                    sharkY = j;

                    map[i][j] = 0;
                }
            }
        }

        res = 0;
        size = 2;
        eatCnt = 0;
        isEnd = false;
        while (!isEnd) {
            time = 0;
            visited = new boolean[N][N];

            if (eatCnt == size) {
                size++;
                eatCnt = 0;
            }

            moveShark();

            res += time;
        }

        System.out.println(res);
    }

    private static void moveShark() {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(sharkX, sharkY, 0));

        visited[sharkX][sharkY] = true;

        int minX = INF, minY = INF, minTime = INF;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            if (now.time >= minTime)
                break;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] > size) continue;

                visited[nx][ny] = true;

                if (map[nx][ny] > 0 && map[nx][ny] < size) {
                    if (nx < minX) {
                        minX = nx;
                        minY = ny;
                        minTime = now.time + 1;
                    } else if (nx == minX) {
                        if (ny < minY) {
                            minY = ny;
                            minTime = now.time + 1;
                        }
                    }
                }

                Q.offer(new Point(nx, ny, now.time + 1));
            }
        }

        if (minTime == INF) {
            isEnd = true;
        } else {
            sharkX = minX;
            sharkY = minY;
            time = minTime;
            eatCnt++;
            map[sharkX][sharkY] = 0;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }

    private static class Point {
        int x, y, time;

        public Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
