/**
 * BOJ : 12100 G2 2048 Easy
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 * 최대 5번 이동
 * 1. 이동 전 현재 depth의 map 백업
 * 2. 상 하 좌 우 이동
 */
public class BOJ_12100_2048Easy {

    static int N, res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        backtrack(0);

        System.out.println(res);
    }

    private static void backtrack(int depth) {
        if (depth == 5) {
            res = Math.max(res, findMax());
            return;
        }

        int[][] copyMap = new int[N][N];
        for (int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, copyMap[i], 0, N);

        for (int d = 0; d < 4; d++) {
            moveBlock(d);
            backtrack(depth + 1);

            for (int i = 0; i < N; i++)
                System.arraycopy(copyMap[i], 0, map[i], 0, N);
        }
    }

    private static int findMax() {
        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                max = Math.max(max, map[i][j]);
        }
        return max;
    }

    private static void moveBlock(int dir) {
        switch (dir) {
            case 0: // 상
                for (int i = 0; i < N; i++) {
                    int idx = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[j][i] == 0) continue;

                        if (map[j][i] != block) {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[idx][i] = block;
                            idx++;
                        } else {
                            map[idx - 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                    }
                }
                break;
            case 1: // 하
                for (int i = 0; i < N; i++) {
                    int idx = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[j][i] == 0) continue;

                        if (map[j][i] != block) {
                            block = map[j][i];
                            map[j][i] = 0;
                            map[idx][i] = block;
                            idx--;
                        } else {
                            map[idx + 1][i] = block * 2;
                            block = 0;
                            map[j][i] = 0;
                        }
                    }
                }
                break;
            case 2: // 좌
                for (int i = 0; i < N; i++) {
                    int idx = 0;
                    int block = 0;
                    for (int j = 0; j < N; j++) {
                        if (map[i][j] == 0) continue;

                        if (map[i][j] != block) {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][idx] = block;
                            idx++;
                        } else {
                            map[i][idx - 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                    }
                }
                break;
            case 3: // 우
                for (int i = 0; i < N; i++) {
                    int idx = N - 1;
                    int block = 0;
                    for (int j = N - 1; j >= 0; j--) {
                        if (map[i][j] == 0) continue;

                        if (map[i][j] != block) {
                            block = map[i][j];
                            map[i][j] = 0;
                            map[i][idx] = block;
                            idx--;
                        } else {
                            map[i][idx + 1] = block * 2;
                            block = 0;
                            map[i][j] = 0;
                        }
                    }
                }
                break;
        }
    }
}
