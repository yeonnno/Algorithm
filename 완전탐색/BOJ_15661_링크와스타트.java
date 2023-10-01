/**
 * BOJ : 15661 S1 링크와 스타트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15661_링크와스타트 {

    static int N, res;
    static int[][] map;
    static boolean[] selected;
    static boolean isZero;

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

        selected = new boolean[N];
        res = Integer.MAX_VALUE;
        isZero = false;

        for (int i = 2; i < N - 1; i++) {
            backtrack(0, 0, i);
        }

        System.out.println(res);
    }

    private static void backtrack(int depth, int pre, int idx) {
        if (isZero) return;

        if (depth == idx) {
            int min = calc();
            res = Math.min(res, min);
            if (res == 0) isZero = true;
            return;
        }

        for (int i = pre; i < N; i++) {
            selected[i] = true;
            backtrack(depth + 1, i + 1, idx);
            selected[i] = false;
        }
    }

    private static int calc() {
        int teamA = 0;
        int teamB = 0;

        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                if (selected[i] && selected[j]) {
                    teamA += map[i][j] + map[j][i];
                } else if (!selected[i] && !selected[j]) {
                    teamB += map[i][j] + map[j][i];
                }
            }
        }

        return Math.abs(teamA - teamB);
    }
}
