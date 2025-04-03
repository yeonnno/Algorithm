/**
 * BOJ : 1461 G4 도서관
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01461_도서관 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x > 0)
                pos.offer(x);
            else
                neg.offer(Math.abs(x));
        }

        int max = Math.max(!pos.isEmpty() ? pos.peek() : 0, !neg.isEmpty() ? neg.peek() : 0);

        int res = 0;

        while (!pos.isEmpty()) {
            int now = pos.poll();

            for (int i = 0; i < M - 1; i++) {
                pos.poll();

                if (pos.isEmpty()) break;
            }

            res += now * 2;
        }

        while (!neg.isEmpty()) {
            int now = neg.poll();

            for (int i = 0; i < M - 1; i++) {
                neg.poll();

                if (neg.isEmpty()) break;
            }

            res += now * 2;
        }

        res -= max;

        System.out.println(res);
    }
}
