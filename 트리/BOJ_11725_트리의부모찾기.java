/**
 * BOJ : 11725 S2 트리의 부모 찾기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_11725_트리의부모찾기 {

    static int N;
    static int[] parent;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

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

        parent = new int[N + 1];
        visited = new boolean[N + 1];

        DFS(1);

        for (int i = 2; i <= N; i++)
            sb.append(parent[i]).append("\n");

        System.out.print(sb);
    }

    private static void DFS(int now) {
        visited[now] = true;

        for (int next : tree[now]) {
            if (visited[next]) continue;

            visited[next] = true;
            parent[next] = now;
            DFS(next);
        }
    }
}
