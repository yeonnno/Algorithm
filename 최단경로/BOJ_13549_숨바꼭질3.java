/**
 * BOJ : 13549 G5 숨바꼭질 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_13549_숨바꼭질3 {

    static int N, K, INF = 100001;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[INF];
        Arrays.fill(dist, -1);

        BFS();

        System.out.println(dist[K]);
    }

    private static void BFS() {
        Deque<Integer> DQ = new LinkedList<>();
        DQ.add(N);
        dist[N] = 0;

        while (!DQ.isEmpty()) {
            int now = DQ.poll();

            if (now == K) return;

            if (now * 2 < INF && dist[now * 2] == -1) {
                dist[now * 2] = dist[now];
                DQ.addFirst(now * 2);
            }

            if (now > 0 && dist[now - 1] == -1) {
                dist[now - 1] = dist[now] + 1;
                DQ.add(now - 1);
            }

            if (now < INF - 1 && dist[now + 1] == -1) {
                dist[now + 1] = dist[now] + 1;
                DQ.add(now + 1);
            }
        }
    }
}
