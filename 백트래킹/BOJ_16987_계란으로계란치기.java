/**
 * BOJ : 16987 G5 계란으로 계란치기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_계란으로계란치기 {

    static int N, res;
    static int[][] egg;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        egg = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                egg[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;

        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int cnt) {
        if (depth == N) {
            res = Math.max(res, cnt);
            return;
        }

        if (egg[depth][0] <= 0 || cnt == N - 1) {
            backtrack(depth + 1, cnt);
            return;
        }

        int tmp = cnt;
        for (int i = 0; i < N; i++) {
            if (i == depth) continue;
            if (egg[i][0] <= 0) continue;

            egg[depth][0] -= egg[i][1];
            egg[i][0] -= egg[depth][1];

            if (egg[depth][0] <= 0) cnt++;
            if (egg[i][0] <= 0) cnt++;

            backtrack(depth + 1, cnt);

            egg[depth][0] += egg[i][1];
            egg[i][0] += egg[depth][1];
            cnt = tmp;
        }
    }
}
