/**
 * BOJ : 1976 G4 여행 가자
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01976_여행가자 {

    static int N, M;
    static int[] parent, city;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int x = Integer.parseInt(st.nextToken());

                if (i < j && x == 1)
                    union(i, j);
            }
        }

        city = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            city[i] = Integer.parseInt(st.nextToken());

        if (checkCity()) System.out.println("YES");
        else System.out.println("NO");
    }

    private static boolean checkCity() {
        int tmp = find(city[0]);
        for (int i = 1; i < M; i++) {
            if (tmp != find(city[i])) return false;
        }
        return true;
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
