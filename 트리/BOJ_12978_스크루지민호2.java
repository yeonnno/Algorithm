/**
 * BOJ : 12978 G3 스크루지 민호 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12978_스크루지민호2 {

    static int N;
    static int[][] dp;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            tree[x].add(y);
            tree[y].add(x);
        }

        dp = new int[2][N + 1];
        visited = new boolean[N + 1];

        DFS(1);

        System.out.println(Math.min(dp[0][1], dp[1][1]));
    }

    private static void DFS(int now) {
        visited[now] = true;

        dp[1][now] = 1;

        for (int next : tree[now]) {
            if (visited[next]) continue;

            DFS(next);

            dp[0][now] += dp[1][next];
            dp[1][now] += Math.min(dp[0][next], dp[1][next]);
        }
    }
}
