/**
 * BOJ : 02615 S1 오목
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02615_오목 {

    static int[][] map;
    static int[] dx = {-1, 0, 1, 1};
    static int[] dy = {1, 1, 1, 0};
    static int resColor, resX, resY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[20][20];
        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (solve()) {
            System.out.println(resColor);
            System.out.println(resX + " " + resY);
        } else {
            System.out.println(resColor);
        }
    }

    private static boolean solve() {
        for (int i = 1; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                if (map[i][j] != 0) {
                    if (checkFive(i, j, map[i][j])) {
                        resColor = map[i][j];
                        resX = i;
                        resY = j;
                        return true;
                    }
                }
            }
        }

        resColor = 0;
        return false;
    }

    private static boolean checkFive(int x, int y, int color) {
        for (int d = 0; d < 4; d++) {
            int nx = x;
            int ny = y;
            int cnt = 1;

            while (true) {
                nx += dx[d];
                ny += dy[d];

                if (!isPossible(nx, ny) || map[nx][ny] != color) break;

                cnt++;
            }

            if (cnt == 5) {
                nx = x - dx[d];
                ny = y - dy[d];

                if (map[nx][ny] != color) return true;
                else return false;
            }
        }

        return false;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx > 0 && nx <= 19 && ny > 0 && ny <= 19) {
            return true;
        }
        return false;
    }
}
