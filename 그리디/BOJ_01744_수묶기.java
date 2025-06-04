/**
 * BOJ : 1744 G4 수 묶기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_01744_수묶기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pos = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> neg = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) pos.offer(x);
            else neg.offer(x);
        }

        int res = 0;

        while (!pos.isEmpty()) {
            int now = pos.poll();

            if (pos.isEmpty()) {
                res += now;
                break;
            }

            if (now == 1)
                res += now;
            else if (pos.peek() == 1)
                res += now + pos.poll();
            else
                res += now * pos.poll();
        }

        while (!neg.isEmpty()) {
            int now = neg.poll();

            if (neg.isEmpty()) {
                res += now;
                break;
            }

            if (neg.peek() == 0)
                neg.poll();
            else
                res += now * neg.poll();
        }

        System.out.println(res);
    }
}
