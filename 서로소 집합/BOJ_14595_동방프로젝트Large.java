/**
 * BOJ : 14595 G3 동방 프로젝트 Large
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_14595_동방프로젝트Large {

    static int N, M;
    static int[] parent;
    static int[][] merge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;

        if (M == 0) {
            merge = new int[1][2];
            merge[0][0] = merge[0][1] = 0;
        } else {
            merge = new int[M][2];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                merge[i][0] = Integer.parseInt(st.nextToken());
                merge[i][1] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(merge, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        int start = merge[0][0], end = merge[0][1];
        for (int i = 1; i < M; i++) {
            if (end < merge[i][0]) {
                for (int j = start; j <= end; j++)
                    union(start, j);

                start = merge[i][0];
                end = merge[i][1];
            } else if (end < merge[i][1]) {
                end = merge[i][1];
            }
        }

        for (int i = start; i <= end; i++)
            union(start, i);

        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= N; i++)
            set.add(find(i));

        System.out.println(set.size());
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
