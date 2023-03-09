/**
 * BOJ : 10971 S2 외판원 순회 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10971_외판원순회2 {

    static int N, start, res;
    static int[][] W;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        W = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        start = 1;
        res = Integer.MAX_VALUE;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            start = i;
            travel(i, 0, 0);
        }

        System.out.println(res);
    }

    private static void travel(int idx, int cnt, int cost) {
        if (cnt == N - 1) {
            if (W[idx][start] != 0) {
                cost += W[idx][start];
                res = Math.min(res, cost);
            }
        } else {
            for (int i = 0; i < N; i++) {
                if (!visited[i] && W[idx][i] != 0) {
                    visited[i] = true;
                    travel(i, cnt + 1, cost + W[idx][i]);
                    visited[i] = false;
                }
            }
        }
    }
}
