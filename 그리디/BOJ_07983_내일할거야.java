/**
 * BOJ : 7983 G5 내일 할거야
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_07983_내일할거야 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Task> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            PQ.offer(new Task(d, t));
        }

        int res = Integer.MAX_VALUE;
        while (!PQ.isEmpty()) {
            Task now = PQ.poll();

            res = Math.min(res, now.t) - now.d;
        }

        System.out.println(res);
    }

    private static class Task implements Comparable<Task> {
        int d, t;

        public Task(int d, int t) {
            this.d = d;
            this.t = t;
        }

        @Override
        public int compareTo(Task o) {
            return o.t - this.t;
        }
    }
}
