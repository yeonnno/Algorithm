/**
 * BOJ : 1043 G4 거짓말
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01043_거짓말 {

    static int N, M, res;
    static int[] parent;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        party = new ArrayList[M + 1];
        for (int i = 0; i <= M; i++)
            party[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        for (int i = 0; i < len; i++)
            union(0, Integer.parseInt(st.nextToken()));

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int tmp = Integer.parseInt(st.nextToken());

            if (tmp == 0) continue;

            int x = Integer.parseInt(st.nextToken());
            party[i].add(x);

            for (int j = 1; j < tmp; j++) {
                int y = Integer.parseInt(st.nextToken());

                party[i].add(y);
                union(x, y);
            }
        }

        res = 0;
        for (int i = 1; i <= M; i++) {
            boolean check = false;

            for (int p : party[i]) {
                if (find(p) == 0)
                    check = true;
            }

            if (!check) res++;
        }

        System.out.println(res);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (y == 0) parent[x] = y;
            else parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
