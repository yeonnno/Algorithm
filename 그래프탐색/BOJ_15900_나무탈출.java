/**
 * BOJ : 15900 S1 나무 탈출
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15900_나무탈출 {

    static int N, total;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        total = 0;

        DFS(0, 1, 0);

        System.out.println(total % 2 == 1 ? "Yes" : "No");
    }

    private static void DFS(int depth, int now, int pre) {
        boolean isLeaf = true;

        for (int next : adj[now]) {
            if (next != pre) {
                isLeaf = false;
                DFS(depth + 1, next, now);
            }
        }

        if (isLeaf)
            total += depth;
    }
}
