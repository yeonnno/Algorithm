/**
 * BOJ : 13904 G3 과제
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13904_과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Task> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            PQ.offer(new Task(d, w));
        }

        boolean[] visited = new boolean[1001];

        int res = 0;
        while (!PQ.isEmpty()) {
            Task now = PQ.poll();

            if (!visited[now.d]) {
                res += now.w;
                visited[now.d] = true;
            } else {
                for (int i = now.d - 1; i >= 1; i--) {
                    if (visited[i]) continue;

                    res += now.w;
                    visited[i] = true;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    private static class Task implements Comparable<Task> {
        int d, w;

        public Task(int d, int w) {
            this.d = d;
            this.w = w;
        }

        @Override
        public int compareTo(Task o) {
            return o.w - this.w;
        }
    }
}
