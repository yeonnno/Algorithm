/**
 * BOJ : 14267 G4 회사 문화 1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14267_회사문화1 {

    static int N, M;
    static int[] res;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == -1) continue;

            tree[x].add(i);
        }

        res = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            res[x] += cost;
        }

        DFS(1);

        for (int i = 1; i <= N; i++)
            sb.append(res[i]).append(" ");
        System.out.println(sb);
    }

    private static void DFS(int now) {
        for (int next : tree[now]) {
            res[next] += res[now];
            DFS(next);
        }
    }
}
