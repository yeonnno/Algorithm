/**
 * BOJ : 3085 S2 사탕 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_03085_사탕게임 {

    static int N, res;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        res = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                swap(i, j, i, j + 1);
                countSameColor();
                swap(i, j + 1, i, j);
            }
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N; j++) {
                swap(i, j, i + 1, j);
                countSameColor();
                swap(i + 1, j, i, j);
            }
        }

        System.out.println(res);
    }

    private static void countSameColor() {
        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    cnt++;
                    res = Math.max(res, cnt);
                } else {
                    cnt = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 1;

            for (int j = 0; j < N - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    cnt++;
                    res = Math.max(res, cnt);
                } else {
                    cnt = 1;
                }
            }
        }
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = map[x1][y1];
        map[x1][y1] = map[x2][y2];
        map[x2][y2] = tmp;
    }
}
