/**
 * BOJ : 17141 G4 연구소2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17141_연구소2 {

    static int N, M, zeroCnt, res;
    static int[][] map, copyMap;
    static ArrayList<Point> virus;
    static boolean[] visited;
    static Queue<Point> Q;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        res = Integer.MAX_VALUE;
        zeroCnt = 0;

        map = new int[N][N];
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virus.add(new Point(i, j));
                } else if (map[i][j] == 0) {
                    zeroCnt++;
                }
            }
        }

        zeroCnt += virus.size() - M;
        if (zeroCnt == 0) {
            res = 0;
        }
        visited = new boolean[virus.size()];

        comb(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    private static void comb(int depth, int idx) {
        if (depth == M) {
            
            spreadVirus();
            
        } else {
            for (int cur = idx; cur < virus.size(); cur++) {
                visited[cur] = true;
                comb(depth + 1, cur + 1);
                visited[cur] = false;
            }
        }
    }

    private static void spreadVirus() {
        Q = new LinkedList<>();

        copyMap = new int[N][N];
        copy();

        // 선택된 바이러스만 Q에 담아줌
        for (int i = 0; i < virus.size(); i++) {
            if (visited[i]) {
                Q.add(virus.get(i));
            }
        }

        int time = 0;
        int zCnt = zeroCnt;
        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();
                int x = now.x;
                int y = now.y;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (!isPossible(nx, ny)) continue;
                    if (copyMap[nx][ny] != 0) continue;

                    copyMap[nx][ny] = 2;
                    zCnt--;

                    Q.add(new Point(nx, ny));
                }
            }

            time++;

            if (zCnt == 0) {
                res = Math.min(res, time);
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
    }

    private static void copy() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    copyMap[i][j] = 0;
                } else {
                    copyMap[i][j] = map[i][j];
                }
            }
        }

        // 선택된 바이러스의 위치에만 2를 넣어줌
        for (int i = 0; i < virus.size(); i++) {
            if (visited[i]) {
                Point p = virus.get(i);
                copyMap[p.x][p.y] = 2;
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
