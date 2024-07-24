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
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];

            findParent(x, y);
        }

        System.out.print(sb);
    }

    private static void findParent(int x, int y) {
        while (x > 0) {
            visited[x] = true;
            x = parent[x];
        }

        while (y > 0) {
            if (visited[y]) {
                sb.append(y).append("\n");
                return;
            }

            y = parent[y];
        }
    }
}
