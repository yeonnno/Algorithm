/**
 * BOJ : 16562 G4 친구비
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16562_친구비 {

    static int N, M, K, res;
    static int[] friendCost, parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        friendCost = new int[N + 1];
        parent = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            friendCost[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        res = 0;
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            int root = find(i);

            if (visited[root]) {
                visited[i] = true;
                continue;
            }

            res += friendCost[root];

            visited[root] = true;
            visited[i] = true;
        }

        if (res <= K) System.out.println(res);
        else System.out.println("Oh no");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (friendCost[x] > friendCost[y]) parent[x] = y;
            else parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
