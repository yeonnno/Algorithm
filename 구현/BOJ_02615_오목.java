/**
 * BOJ : 2615 S1 오목
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02615_오목 {

    static final int N = 20;
    static int[][] map;
    static int res, resX, resY;
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        map = new int[N][N];
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (play())
            sb.append(res).append("\n").append(resX).append(" ").append(resY);
        else
            sb.append(0);

        System.out.println(sb);
    }

    private static boolean play() {
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0) continue;

                if (isFive(i, j, map[i][j])) {
                    res = map[i][j];
                    resX = i;
                    resY = j;

                    return true;
                }
            }
        }

        return false;
    }

    private static boolean isFive(int x, int y, int color) {
        for (int d = 0; d < 4; d++) {
            int nx = x, ny = y, cnt = 1;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (!isPossible(nx, ny) || map[nx][ny] != color) break;

                cnt++;
            }

            if (cnt == 5) {
                nx = x - dx[d];
                ny = y - dy[d];

                if (map[nx][ny] != color)
                    return true;
            }
        }

        return false;
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 1 && nx < N && ny >= 1 && ny < N;
    }
}
