/**
 * BOJ : 12761 S1 돌다리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12761_돌다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] res = new int[100001];
        boolean[] visited = new boolean[100001];

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(N);

        visited[N] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();
            int[] tmp = {now - 1, now + 1, now - A, now + A, now - B, now + B, now * A, now * B};

            for (int d = 0; d < 8; d++) {
                int next = tmp[d];

                if (next < 0 || next > 100000 || visited[next]) continue;

                visited[next] = true;
                res[next] = res[now] + 1;
                Q.offer(next);
            }

            if (res[M] > 0)
                break;
        }

        System.out.println(res[M]);
    }
}
