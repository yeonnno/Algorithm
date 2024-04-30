/**
 * BOJ : 14502 G4 연구소
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {

    static int N, M, res;
    static int[][] map, copyMap;
    static ArrayList<Virus> virus;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        copyMap = new int[N][M];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2)
                    virus.add(new Virus(i, j));
            }
        }

        res = 0;

        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int pre) {
        if (depth == 3) {
            for (int i = 0; i < N; i++)
                System.arraycopy(map[i], 0, copyMap[i], 0, M);

            for (Virus v : virus)
                spreadVirus(v.x, v.y);

            countSafeArea();
        } else {
            for (int cur = pre; cur < N * M; cur++) {
                int x = cur / M;
                int y = cur % M;

                if (map[x][y] != 0) continue;

                map[x][y] = 1;
                backtrack(depth + 1, cur + 1);
                map[x][y] = 0;
            }
        }
    }

    private static void spreadVirus(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isPossible(nx, ny) || copyMap[nx][ny] != 0) continue;

            copyMap[nx][ny] = 2;
            spreadVirus(nx,  ny);
        }
    }

    private static void countSafeArea() {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) cnt++;
            }
        }

        res = Math.max(res, cnt);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
