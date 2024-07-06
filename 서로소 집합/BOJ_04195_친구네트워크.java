/**
 * BOJ : 4195 G2 친구 네트워크
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_04195_친구네트워크 {

    static int F;
    static int[] parent, level;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            F = Integer.parseInt(br.readLine());

            level = new int[F * 2];
            parent = new int[F * 2];
            for (int i = 0; i < F * 2; i++) {
                level[i] = 1;
                parent[i] = i;
            }

            int idx = 0;
            map = new HashMap<>();
            for (int i = 0; i < F; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) map.put(a, idx++);
                if (!map.containsKey(b)) map.put(b, idx++);

                sb.append(union(map.get(a), map.get(b))).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            level[x] += level[y];
        }
        return level[x];
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
