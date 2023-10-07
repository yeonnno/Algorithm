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
    static int[] dist;
    static ArrayList<Shortcut>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[10001];
        adj = new ArrayList[10001];
        for (int i = 0; i < 10001; i++) {
            dist[i] = i;
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adj[s].add(new Shortcut(e, w));
        }

        dijkstra(0);

        System.out.println(dist[D]);
    }

    private static void dijkstra(int now) {
        if (now > D) return;

        if (dist[now + 1] > dist[now] + 1) {
            dist[now + 1] = dist[now] + 1;
        }

        for (int i = 0; i < adj[now].size(); i++) {
            Shortcut next = adj[now].get(i);

            if (dist[next.e] > dist[now] + next.w) {
                dist[next.e] = dist[now] + next.w;
            }
        }

        dijkstra(now + 1);
    }

    private static class Shortcut {
        int e;
        int w;

        Shortcut(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
}
