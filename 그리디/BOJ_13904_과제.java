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

            if (!visited[now.day]) {
                res += now.score;
                visited[now.day] = true;
            } else {
                for (int i = now.day - 1; i >= 1; i--) {
                    if (visited[i]) continue;

                    res += now.score;
                    visited[i] = true;
                    break;
                }
            }
        }

        System.out.println(res);
    }

    private static class Task implements Comparable<Task> {
        int day;
        int score;

        public Task(int day, int score) {
            this.day = day;
            this.score = score;
        }

        @Override
        public int compareTo(Task o) {
            return o.score - this.score;
        }
    }
}
