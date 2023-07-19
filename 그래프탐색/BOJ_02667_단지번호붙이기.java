/**
 * BOJ : 2667 S1 단지번호붙이기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_02667_단지번호붙이기 {

    static int N, res;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = tmp.charAt(j) - '0';
            }
        }

        res = 0;
        count = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    res++;
                    BFS(new Point(i, j));
                }
            }
        }

        Collections.sort(count);

        sb.append(res).append("\n");
        for (int c : count) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(p);
        map[p.x][p.y] = 0;

        int cnt = 0;
        while (!Q.isEmpty()) {
            Point now = Q.poll();
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] == 0) continue;

                map[nx][ny] = 0;
                Q.add(new Point(nx, ny));
            }
        }
        count.add(cnt);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) return true;
        else return false;
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
