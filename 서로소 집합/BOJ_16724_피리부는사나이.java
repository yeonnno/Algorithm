/**
 * BOJ : 16724 G3 피리 부는 사나이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_16724_피리부는사나이 {

    static int N, M;
    static int[] parent;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N * M];
        for (int i = 0; i < N * M; i++)
            parent[i] = i;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                int dir = getDir(s.charAt(j));

                int nx = i + dx[dir];
                int ny = j + dy[dir];

                union(i * M + j, nx * M + ny);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < N * M; i++)
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

    private static int getDir(char ch) {
        switch (ch) {
            case 'U':
                return 0;
            case 'R':
                return 1;
            case 'D':
                return 2;
            case 'L':
                return 3;
        }
        return -1;
    }
}
