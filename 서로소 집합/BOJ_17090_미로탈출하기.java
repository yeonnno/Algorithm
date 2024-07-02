/**
 * BOJ : 17090 G3 미로 탈출하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17090_미로탈출하기 {

    static int N, M, res;
    static int[] parent;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N * M + 1];
        for (int i = 1; i <= N * M; i++)
            parent[i] = i;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                int dir = getDir(s.charAt(j));
                int nx = i + dx[dir];
                int ny = j + dy[dir];

                if (isPossible(nx, ny))
                    union(i * M + j + 1, nx * M + ny + 1);
                else
                    union(0, i * M + j + 1);
            }
        }

        res = 0;
        for (int i = 1; i <= N * M; i++) {
            if (find(i) == 0)
                res++;
        }

        System.out.println(res);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (y == 0)
            parent[x] = y;
        else
            parent[y] = x;
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
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
