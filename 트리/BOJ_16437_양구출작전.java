/**
 * BOJ : 16437 G3 양 구출 작전
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16437_양구출작전 {

    static int N;
    static long[] info;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        info = new long[N + 1];
        for (int i = 2; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            char t = st.nextToken().charAt(0);
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            tree[p].add(i);

            if (t == 'W')
                info[i] = a * -1;
            else
                info[i] = a;
        }

        DFS(1, -1);

        System.out.println(info[1]);
    }

    private static void DFS(int now, int parent) {
        for (int next : tree[now]) {
            DFS(next, now);
        }

        if (parent != -1) {
            if (info[now] > 0) {
                info[parent] += info[now];
            }
        }
    }
}
