/**
 * BOJ : 1911 G5 흙길 보수하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01911_흙길보수하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Pool> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            PQ.offer(new Pool(start, end));
        }

        int res = 0, range = 0;
        while (!PQ.isEmpty()) {
            Pool now = PQ.poll();

            if (range < now.start) {
                range = now.start;
            }

            while (range < now.end) {
                range += L;
                res++;
            }
        }

        System.out.println(res);
    }

    private static class Pool implements Comparable<Pool> {
        int start;
        int end;

        public Pool(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pool o) {
            if (this.start == o.start)
                return this.end - o.end;

            return this.start - o.start;
        }
    }
}
