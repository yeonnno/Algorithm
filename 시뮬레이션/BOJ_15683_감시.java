/**
 * BOJ : 15683 G3 감시
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15683_감시 {

    static int N, M, res;
    static final int UP = 0, RIGHT = 1, DOWN = 2, LEFT = 3;
    static int[][] map, copyMap;
    static ArrayList<CCTV> cctvList;
    static int[] select;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        cctvList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0 && map[i][j] != 6)
                    cctvList.add(new CCTV(map[i][j], i, j));
            }
        }

        int size = cctvList.size();
        res = Integer.MAX_VALUE;

        select = new int[size];
        permutation(0, size);

        System.out.println(res);
    }

    private static void permutation(int depth, int size) {
        if (depth == size) {
            copyMap = new int[N][M];
            for (int i = 0; i < N; i++)
                System.arraycopy(map[i], 0, copyMap[i], 0, M);

            for (int i = 0; i < size; i++)
                getDir(cctvList.get(i), select[i]);

            countZero();

            return;
        }

        for (int cur = 0; cur < 4; cur++) {
            select[depth] = cur;
            permutation(depth + 1, size);
        }
    }

    private static void countZero() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0)
                    cnt++;
            }
        }

        res = Math.min(res, cnt);
    }

    private static void getDir(CCTV cctv, int d) {
        int num = cctv.num;

        if (num == 1) {
            if (d == 0) watch(cctv, UP);
            else if (d == 1) watch(cctv, RIGHT);
            else if (d == 2) watch(cctv, DOWN);
            else if (d == 3) watch(cctv, LEFT);
        } else if (num == 2) {
            if (d == 0 || d == 2) {
                watch(cctv, UP);
                watch(cctv, DOWN);
            } else {
                watch(cctv, RIGHT);
                watch(cctv, LEFT);
            }
        } else if (num == 3) {
            if (d == 0) {
                watch(cctv, UP);
                watch(cctv, RIGHT);
            } else if (d == 1) {
                watch(cctv, RIGHT);
                watch(cctv, DOWN);
            } else if (d == 2) {
                watch(cctv, DOWN);
                watch(cctv, LEFT);
            } else if (d == 3) {
                watch(cctv, LEFT);
                watch(cctv, UP);
            }
        } else if (num == 4) {
            if (d == 0) {
                watch(cctv, UP);
                watch(cctv, RIGHT);
                watch(cctv, LEFT);
            } else if (d == 1) {
                watch(cctv, UP);
                watch(cctv, RIGHT);
                watch(cctv, DOWN);
            } else if (d == 2) {
                watch(cctv, RIGHT);
                watch(cctv, DOWN);
                watch(cctv, LEFT);
            } else if (d == 3) {
                watch(cctv, UP);
                watch(cctv, DOWN);
                watch(cctv, LEFT);
            }
        } else if (num == 5) {
            watch(cctv, UP);
            watch(cctv, RIGHT);
            watch(cctv, DOWN);
            watch(cctv, LEFT);
        }
    }

    private static void watch(CCTV cctv, int d) {
        int nx = cctv.x;
        int ny = cctv.y;

        while (true) {
            nx += dx[d];
            ny += dy[d];

            if (!isPossible(nx, ny) || copyMap[nx][ny] == 6) break;
            if (copyMap[nx][ny] != 0) continue;

            copyMap[nx][ny] = -1;
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

    private static class CCTV {
        int num, x, y;

        public CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
}
