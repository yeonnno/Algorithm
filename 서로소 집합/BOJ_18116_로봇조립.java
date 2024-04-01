/**
 * BOJ : 18116 G4 로봇 조립
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_18116_로봇조립 {

    static int N;
    static final int MAX = 1000001;
    static int[] parent, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        parent = new int[MAX];
        count = new int[MAX];
        for (int i = 1; i < MAX; i++) {
            parent[i] = i;
            count[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if (s.equals("I")) {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(a, b);
            } else {
                int x = Integer.parseInt(st.nextToken());

                sb.append(count[find(x)]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            count[x] += count[y];
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
