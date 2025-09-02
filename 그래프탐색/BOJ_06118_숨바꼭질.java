/**
 * BOJ : 6118 S1 숨바꼭질
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_06118_숨바꼭질 {

    static int N, M, idx, len, cnt;
    static int[] lenArr;
    static boolean[] visited;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adj[s].add(e);
            adj[e].add(s);
        }

        idx = 0;
        len = 0;
        cnt = 0;
        lenArr = new int[N + 1];
        visited = new boolean[N + 1];

        BFS();

        for (int i = 1; i <= N; i++) {
            if (lenArr[i] == len) {
                if (idx == 0)
                    idx = i;

                cnt++;
            }
        }

        sb.append(idx).append(" ").append(len).append(" ").append(cnt);
        System.out.println(sb);
    }

    private static void BFS() {
        Queue<Node> Q = new LinkedList<>();
        Q.offer(new Node(1, 0));

        visited[1] = true;

        while (!Q.isEmpty()) {
            Node now = Q.poll();

            len = Math.max(len, now.depth);
            lenArr[now.idx] = now.depth;

            for (int next : adj[now.idx]) {
                if (visited[next]) continue;

                visited[next] = true;
                Q.offer(new Node(next, now.depth + 1));
            }
        }
    }

    private static class Node {
        int idx, depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
