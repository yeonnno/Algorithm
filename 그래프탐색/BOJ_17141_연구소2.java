/**
 * BOJ : 17141 G4 연구소 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {

    static int N, M, zeroCnt, virusSize, res;
    static int[][] map, copyMap;
    static ArrayList<Virus> virus;
    static int[] selected;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        zeroCnt = 0;
        map = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virus.add(new Virus(i, j));
                    map[i][j] = 0;
                }

                if (map[i][j] == 0)
                    zeroCnt++;
            }
        }

        if (zeroCnt == 0) {
            System.out.println(0);
        } else {
            virusSize = virus.size();
            res = Integer.MAX_VALUE;
            selected = new int[M];

            backtrack(0, 0);

            if (res == Integer.MAX_VALUE)
                System.out.println(-1);
            else
                System.out.println(res);
        }
    }

    private static void backtrack(int depth, int pre) {
        if (depth == M) {
            spreadVirus();
        } else {
            for (int cur = pre; cur < virusSize; cur++) {
                selected[depth] = cur;
                backtrack(depth + 1, cur + 1);
            }
        }
    }

    private static void spreadVirus() {
        Queue<Virus> Q = new LinkedList<>();

        copyMap = new int[N][N];
        copy();

        int zCnt = zeroCnt;
        for (int sel : selected) {
            Virus v = virus.get(sel);

            Q.offer(v);
            copyMap[v.x][v.y] = 2;
            zCnt--;
        }

        if (zCnt == 0) {
            res = 0;
            return;
        }

        int time = 0;
        while (!Q.isEmpty()) {
            int qSize = Q.size();

            for (int i = 0; i < qSize; i++) {
                Virus now = Q.poll();

                for (int d = 0; d < 4; d++) {
                    int nx = now.x + dx[d];
                    int ny = now.y + dy[d];

                    if (!isPossible(nx, ny) || copyMap[nx][ny] != 0) continue;

                    zCnt--;
                    copyMap[nx][ny] = 2;
                    Q.offer(new Virus(nx, ny));
                }
            }

            time++;

            if (zCnt == 0)
                res = Math.min(res, time);
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static void copy() {
        for (int i = 0; i < N; i++)
            System.arraycopy(map[i], 0, copyMap[i], 0, N);
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
