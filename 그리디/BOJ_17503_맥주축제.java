/**
 * BOJ : 17503 S1 맥주 축제
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17503_맥주축제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Beer> PQ = new PriorityQueue<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            PQ.offer(new Beer(v, c));
        }

        int total = 0, res = -1;
        PriorityQueue<Integer> prefer = new PriorityQueue<>();
        while (!PQ.isEmpty()) {
            Beer now = PQ.poll();

            prefer.offer(now.v);
            total += now.v;

            if (prefer.size() > N)
                total -= prefer.poll();

            if (prefer.size() == N && total >= M) {
                res = now.c;
                break;
            }
        }

        System.out.println(res);
    }

    private static class Beer implements Comparable<Beer> {
        int v, c;

        public Beer(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Beer o) {
            if (this.c == o.c)
                return o.v - this.v;
            return this.c - o.c;
        }
    }
}
