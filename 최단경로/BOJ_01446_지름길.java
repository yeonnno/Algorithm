/**
 * BOJ : 1446 S1 지름길
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01446_지름길 {

    static int N, D;
    static ArrayList<Shortcut>[] adj;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[10001];
        dist = new int[10001];
        for (int i = 0; i < 10001; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Shortcut(e, w));
        }
        
        DFS(0);

        System.out.println(dist[D]);
    }

    private static void DFS(int depth) {
        if (depth > D) return;

        if (dist[depth + 1] > dist[depth] + 1) {
            dist[depth + 1] = dist[depth] + 1;
        }

        for (int i = 0; i < adj[depth].size(); i++) {
            Shortcut next = adj[depth].get(i);

            if (dist[next.e] > dist[depth] + next.w) {
                dist[next.e] = dist[depth] + next.w;
            }
        }

        DFS(depth + 1);
    }

    private static class Shortcut implements Comparable<Shortcut> {
        int e;
        int w;

        Shortcut(int e, int w) {
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Shortcut o) {
            return this.w - o.w;
        }
    }
}
