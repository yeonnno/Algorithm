/**
 * BOJ : 1263 G5 시간 관리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01263_시간관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Task> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            PQ.offer(new Task(t, s));
        }

        int res = 1000000;
        while (!PQ.isEmpty()) {
            Task now = PQ.poll();

            res = Math.min(res, now.s) - now.t;

            if (res < 0) {
                res = -1;
                break;
            }
        }

        System.out.println(res);
    }

    private static class Task implements Comparable<Task> {
        int t;
        int s;

        public Task(int t, int s) {
            this.t = t;
            this.s = s;
        }

        @Override
        public int compareTo(Task o) {
            return o.s - this.s;
        }
    }
}
