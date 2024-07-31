/**
 * BOJ : 19542 G3 전단지 돌리기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_19542_전단지돌리기 {

    static int N, S, D, res;
    static int[] depth;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

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

        res = 0;
        depth = new int[N + 1];

        DFS(S, -1);

        System.out.println(res * 2);
    }

    private static int DFS(int now, int parent) {
        for (int next : tree[now]) {
            if (next == parent) continue;

            depth[now] = Math.max(depth[now], DFS(next, now) + 1);
        }

        if (now != S && depth[now] >= D)
            res++;

        return depth[now];
    }
}
