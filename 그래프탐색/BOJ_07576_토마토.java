/**
 * BOJ : 7576 G5 토마토
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_07576_토마토 {

    static int M, N, res;
    static int[][] map;
    static Queue<Point> tomato;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        tomato = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    tomato.add(new Point(i, j));
                }
            }
        }

        res = 0;
        BFS();

        if (checkZero()) {
            System.out.println(res-1);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean checkZero() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    private static void BFS() {
        while (!tomato.isEmpty()) {
            int size = tomato.size();

            for (int i = 0; i < size; i++) {
                Point now = tomato.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny)) continue;
                    if (map[nx][ny] != 0) continue;

                    map[nx][ny] = 1;
                    tomato.add(new Point(nx, ny));
                }
            }

            res++;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
