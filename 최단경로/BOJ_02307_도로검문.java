/**
 * BOJ : 2307 G1 도로검문
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_02307_도로검문 {

    static int N, M, res;
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] oriDist, path, blockDist;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[s].add(new Node(e, cost));
            adj[e].add(new Node(s, cost));
        }

        path = new int[N + 1];
        oriDist = new int[N + 1];
        Arrays.fill(oriDist, INF);
        oriDist[1] = 0;

        visited = new boolean[N + 1];

        dijkstra(false, oriDist, -1, -1);

        res = -INF;
        int start = N;
        while (true) {
            if (start == 1) break;

            blockDist = new int[N + 1];
            Arrays.fill(blockDist, INF);
            blockDist[1] = 0;

            visited = new boolean[N + 1];

            int end = path[start];

            dijkstra(true, blockDist, end, start);

            if (blockDist[N] == INF) {
                res = -1;
                break;
            }

            res = Math.max(res, blockDist[N] - oriDist[N]);

            start = end;
        }

        System.out.println(res);
    }

    private static void dijkstra(boolean isBlock, int[] dist, int start, int end) {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.add(new Node(1, 0));

        if (isBlock) {
            while (!PQ.isEmpty()) {
                Node now = PQ.poll();

                if (visited[now.e]) continue;

                visited[now.e] = true;

                for (Node next : adj[now.e]) {
                    if (now.e == start && next.e == end) continue;

                    if (dist[next.e] > dist[now.e] + next.cost) {
                        dist[next.e] = dist[now.e] + next.cost;
                        PQ.add(new Node(next.e, dist[next.e]));
                    }
                }
            }
        } else {
            while (!PQ.isEmpty()) {
                Node now = PQ.poll();

                if (visited[now.e]) continue;

                visited[now.e] = true;

                for (Node next : adj[now.e]) {
                    if (dist[next.e] > dist[now.e] + next.cost) {
                        dist[next.e] = dist[now.e] + next.cost;
                        PQ.add(new Node(next.e, dist[next.e]));
                        path[next.e] = now.e;
                    }
                }
            }
        }
    }

    private static class Node implements Comparable<Node> {
        int e;
        int cost;

        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
/*
dist = 0 1 3 3 4 4
path = 0 1 2 1 4 3
1 -> 2 -> 3 -> 6
 */
