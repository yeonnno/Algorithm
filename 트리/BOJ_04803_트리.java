/**
 * BOJ : 4803 G4 트리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_04803_트리 {

    static int N, M, res;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int t = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++)
                parent[i] = i;

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                union(x, y);
            }

            res = 0;
            for (int i = 1; i <= N; i++) {
                int cnt = 0;
                for (int j = 1; j <= N; j++) {
                    if (i == find(j)) cnt++;
                }

                if (cnt > 0) res++;
            }

            sb.append("Case ").append(t).append(": ");
            if (res == 0)
                sb.append("No trees.");
            else if (res == 1)
                sb.append("There is one tree.");
            else
                sb.append("A forest of ").append(res).append(" trees.");
            sb.append("\n");

            t++;
        }

        System.out.print(sb);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        if (x != y) parent[y] = x;
        else parent[x] = 0;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
