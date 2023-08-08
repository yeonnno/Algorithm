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

        res = Integer.MAX_VALUE;
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            start = i;
            travel(i, 0, 0);
            visited[i] = false;
        }

        System.out.println(res);
    }

    private static void travel(int idx, int depth, int cost) {
        if (depth == N - 1) {
            if (W[idx][start] != 0) {
                cost += W[idx][start];
                res = Math.min(res, cost);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] || W[idx][i] == 0) continue;

            visited[i] = true;
            travel(i, depth + 1, cost + W[idx][i]);
            visited[i] = false;
        }
    }
}
