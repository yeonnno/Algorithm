/**
 * BOJ : 7511 G5 소셜 네트워킹 어플리케이션
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_07511_소셜네트워킹어플리케이션 {

    static int N, K, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            K = Integer.parseInt(br.readLine());

            parent = new int[N];
            for (int i = 0; i < N; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (find(a) != find(b)) {
                    union(a, b);
                }
            }

            sb.append("Scenario ").append(t).append(":\n");

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (find(a) == find(b)) sb.append(1);
                else sb.append(0);
                sb.append("\n");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
