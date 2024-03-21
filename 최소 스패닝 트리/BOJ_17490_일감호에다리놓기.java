/**
 * BOJ : 17490 G3 일감호에 다리 놓기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17490_일감호에다리놓기 {

    static int N, M;
    static int[] stone, parent;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static long K, sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());

        stone = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        list = new ArrayList[N + 1];
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
            parent[i] = i;
        }

        for (int i = 2; i < N; i++) {
            list[i].add(i - 1);
            list[i].add(i + 1);
        }
        list[1].add(N);
        list[1].add(2);
        list[N].add(1);
        list[N].add(N - 1);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].remove(Integer.valueOf(b));
            list[b].remove(Integer.valueOf(a));
        }

        for (int i = 1; i <= N; i++) {
            for (int j : list[i]) {
                if (isSameParent(i, j)) continue;

                union(i, j);
            }
        }

        int tmp = find(1);
        boolean check = true;
        for (int i = 2; i <= N; i++) {
            if (tmp == find(i)) continue;

            check = false;
            break;
        }

        if (check) {
            System.out.println("YES");
        } else {
            sum = 0;
            visited = new boolean[N + 1];
            for (int i = 1; i <= N; i++) {
                int x = find(i);
                if (visited[x]) continue;

                visited[x] = true;
                sum += stone[find(i)];
            }

            if (sum <= K) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (stone[x] < stone[y]) parent[y] = x;
            else parent[x] = y;
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return true;
        else return false;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
