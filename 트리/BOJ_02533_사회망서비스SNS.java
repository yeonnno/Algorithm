/**
 * BOJ : 2533 G3 사회망 서비스(SNS)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_02533_사회망서비스SNS {

    static int N;
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    static boolean[] visited;

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

        dp = new int[N + 1][2];
        visited = new boolean[N + 1];

        DFS(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void DFS(int now) {
        visited[now] = true;

        dp[now][0] = 0;
        dp[now][1] = 1;

        for (int next : tree[now]) {
            if (visited[next]) continue;

            DFS(next);

            dp[now][0] += dp[next][1];
            dp[now][1] += Math.min(dp[next][0], dp[next][1]);
        }
    }
}
