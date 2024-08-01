/**
 * BOJ : 11437 G3 LCA
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11437_LCA {

    static int N, M;
    static ArrayList<Integer>[] tree;
    static int[] depth, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

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

        depth = new int[N + 1];
        parent = new int[N + 1];

        setTree(1, 1, 0);

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(LCA(x, y)).append("\n");
        }

        System.out.print(sb);
    }

    private static int LCA(int x, int y) {
        int xh = depth[x];
        int yh = depth[y];

        while (xh > yh) {
            x = parent[x];
            xh--;
        }

        while (xh < yh) {
            y = parent[y];
            yh--;
        }

        while (x != y) {
            x = parent[x];
            y = parent[y];
        }

        return x;
    }

    private static void setTree(int now, int height, int pa) {
        depth[now] = height;
        parent[now] = pa;

        for (int next : tree[now]) {
            if (next != pa)
                setTree(next, height + 1, now);
        }
    }
}
