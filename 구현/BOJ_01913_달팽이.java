/**
 * BOJ : 1913 S3 달팽이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01913_달팽이 {

    static int N, M;
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N][N];

        solution();

        int resX = 0, resY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");

                if (map[i][j] == M) {
                    resX = i + 1;
                    resY = j + 1;
                }
            }
            sb.append("\n");
        }

        sb.append(resX).append(" ").append(resY);

        System.out.println(sb);
    }

    private static void solution() {
        int x = 0, y = 0, d = 0;
        int idx = N * N;

        while (idx != 0) {
            map[x][y] = idx--;

            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isPossible(nx, ny) || map[nx][ny] != 0) {
                d = (d + 1) % 4;
                nx = x + dx[d];
                ny = y + dy[d];
            }

            x = nx;
            y = ny;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
