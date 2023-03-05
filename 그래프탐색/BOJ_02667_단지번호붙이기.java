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
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> houseCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        res = 0;
        visited = new boolean[N][N];
        houseCnt = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    res++;
                    BFS(new Point(i, j));
                }
            }
        }

        Collections.sort(houseCnt);

        System.out.println(res);
        for (int i = 0; i < houseCnt.size(); i++) {
            System.out.println(houseCnt.get(i));
        }
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        visited[p.x][p.y] = true;
        Q.add(p);
        int cnt = 0;

        while (!Q.isEmpty()) {
            Point now = Q.poll();
            int x = now.x;
            int y = now.y;
            cnt++;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (map[nx][ny] != 1 || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                Q.add(new Point(nx, ny));
            }
        }

        houseCnt.add(cnt);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            return true;
        }
        return false;
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
