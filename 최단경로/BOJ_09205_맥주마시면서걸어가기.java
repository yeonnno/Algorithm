/**
 * BOJ : 9205 G5 맥주 마시면서 걸어가기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_09205_맥주마시면서걸어가기 {

    static int N;
    static ArrayList<Point> list;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Point(x, y));
            }

            visited = new boolean[N + 2][N + 2];
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    int dist = manhattan(list.get(i), list.get(j));

                    if (dist <= 1000) visited[i][j] = visited[j][i] = true;
                }
            }

            floyd();

            if (visited[0][N + 1]) sb.append("happy");
            else sb.append("sad");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 0; k < N + 2; k++) {
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j < N + 2; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (visited[i][k] && visited[k][j]) visited[i][j] = true;
                }
            }
        }
    }

    private static int manhattan(Point p1, Point p2) {
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
