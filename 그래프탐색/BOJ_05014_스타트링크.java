/**
 * BOJ : 5014 S1 스타트링크
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_05014_스타트링크 {

    static int F, S, G, U, D, res;
    static int[] count, dir;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dir = new int[2];
        dir[0] = U;
        dir[1] = D * -1;

        res = 0;
        count = new int[F + 1];
        visited = new boolean[F + 1];

        if (BFS(S))
            System.out.println(res);
        else
            System.out.println("use the stairs");
    }

    private static boolean BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(start);

        visited[start] = true;
        count[start] = 0;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            if (now == G) {
                res = count[now];
                return true;
            }

            for (int d = 0; d < 2; d++) {
                int next = now + dir[d];

                if (next > F || next < 1) continue;
                if (visited[next]) continue;

                visited[next] = true;
                count[next] = count[now] + 1;
                Q.offer(next);
            }
        }

        return false;
    }
}
