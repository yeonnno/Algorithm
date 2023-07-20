/**
 * BOJ : 7569 G5 토마토
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_07569_토마토 {

    static int M, N, H, res;
    static int[][][] map;
    static Queue<Point> tomato;
    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][N][M];
        tomato = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if (map[i][j][k] == 1) tomato.add(new Point(j, k, i));
                }
            }
        }

        res = 0;
        BFS();

        if (checkTomato()) {
            System.out.println(res - 1);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (map[i][j][k] == 0) return false;
                }
            }
        }

        return true;
    }

    private static void BFS() {
        while (!tomato.isEmpty()) {
            int size = tomato.size();

            for (int i = 0; i < size; i++) {
                Point now = tomato.poll();

                for (int d = 0; d < 6; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];
                    int nz = now.z + dz[d];

                    if (!isPossible(nx, ny, nz)) continue;
                    if (map[nz][nx][ny] != 0) continue;

                    map[nz][nx][ny] = 1;
                    tomato.add(new Point(nx, ny, nz));
                }
            }
            res++;
        }
    }

    private static boolean isPossible(int nx, int ny, int nz) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M && nz >= 0 && nz < H) return true;
        else return false;
    }

    static class Point {
        int x;
        int y;
        int z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
