/**
 * BOJ : 3584 G4 가장 가까운 공통 조상
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03584_가장가까운공통조상 {

    static int N;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            parent = new int[N + 1];
            for (int i = 0; i < N - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                parent[y] = x;
            }

            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];

            int res = findCommonAncestor(node1, node2);
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static int findCommonAncestor(int node1, int node2) {
        while (node1 > 0) {
            visited[node1] = true;
            node1 = parent[node1];
        }

        while (node2 > 0) {
            if (visited[node2])
                return node2;

            node2 = parent[node2];
        }

        return -1;
    }
}
