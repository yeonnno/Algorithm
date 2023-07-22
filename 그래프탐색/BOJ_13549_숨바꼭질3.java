/**
 * BOJ : 13549 G5 숨바꼭질 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {

    static int N, K, res;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[100001];
        res = 0;
        BFS();

        System.out.println(res);
    }

    private static void BFS() {
        PriorityQueue<Point> PQ = new PriorityQueue<>();
        PQ.add(new Point(N, 0));

        while (!PQ.isEmpty()) {
            Point now = PQ.poll();
            int x = now.x;
            int cnt = now.cnt;

            visited[x] = true;

            if (x == K) {
                res = cnt;
                break;
            }

            if (x * 2 <= 100000 && !visited[x * 2]) {
                PQ.add(new Point(x * 2, cnt));
            }

            if (x + 1 <= 100000 && !visited[x + 1]) {
                PQ.add(new Point(x + 1, cnt + 1));
            }

            if (x - 1 >= 0 && !visited[x - 1]) {
                PQ.add(new Point(x - 1, cnt + 1));
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int cnt;

        Point(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point o) {
            return cnt - o.cnt;
        }
    }
}
