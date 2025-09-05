/**
 * BOJ : 14248 S2 점프 점프
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14248_점프점프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int S = Integer.parseInt(br.readLine());

        int res = 1;
        int[] dir = {1, -1};
        boolean[] visited = new boolean[N + 1];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(S);

        visited[S] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();
            int jump = arr[now];

            for (int d = 0; d < 2; d++) {
                int next = now + (jump * dir[d]);

                if (next < 1 || next > N || visited[next]) continue;

                visited[next] = true;
                Q.offer(next);
                res++;
            }
        }

        System.out.println(res);
    }
}
