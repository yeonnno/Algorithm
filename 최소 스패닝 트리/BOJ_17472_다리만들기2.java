/**
 * BOJ : 17472 G1 다리 만들기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472_다리만들기2 {

    static int N, M, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] parent;
    static PriorityQueue<Node> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) * -1;
            }
        }

        int idx = 1;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != -1) continue;

                BFS(i, j, idx);
                idx++;
            }
        }

        PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) continue;

                makeBridge(i, j, map[i][j]);
            }
        }

        parent = new int[idx];
        for (int i = 1; i < idx; i++) {
            parent[i] = i;
        }

        res = 0;

        kruskal();

        int tmp = find(1);
        boolean check = true;
        for (int i = 2; i < idx; i++) {
            if (tmp == find(i)) continue;
            check = false;
            break;
        }

        if (check) System.out.println(res);
        else System.out.println(-1);
    }

    private static void kruskal() {
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();

            int x = find(node.s);
            int y = find(node.e);

            if (x == y) continue;

            res += node.cost;
            union(node.s, node.e);
        }
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

    private static void makeBridge(int i, int j, int idx) {
        Queue<Node> Q = new LinkedList<>();
        visited = new boolean[N][M];

        for (int d = 0; d < 4; d++) {
            Q.offer(new Node(i, j, 0));
            visited[i][j] = true;

            while (!Q.isEmpty()) {
                Node now = Q.poll();

                int nx = now.s + dx[d];
                int ny = now.e + dy[d];

                if (!isPossible(nx, ny) || visited[nx][ny]) continue;
                if (map[nx][ny] == idx) continue;

                if (map[nx][ny] != 0) {
                    if (now.cost >= 2) {
                        PQ.offer(new Node(idx, map[nx][ny], now.cost));
                        break;
                    }
                } else {
                    visited[nx][ny] = true;
                    Q.offer(new Node(nx, ny, now.cost + 1));
                }
            }

            Q.clear();
        }
    }

    private static void BFS(int i, int j, int idx) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(new Point(i, j));
        visited[i][j] = true;
        map[i][j] = idx;

        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if (visited[nx][ny] || map[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                map[nx][ny] = idx;
                Q.offer(new Point(nx, ny));
            }
        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;

        public Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
