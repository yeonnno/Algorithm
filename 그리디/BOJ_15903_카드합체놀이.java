/**
 * BOJ : 15903 S1 카드 합체 놀이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_15903_카드합체놀이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        PriorityQueue<Long> PQ = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            PQ.offer(Long.parseLong(st.nextToken()));

        for (int i = 0; i < M; i++) {
            long x = PQ.poll();
            long y = PQ.poll();

            PQ.offer(x + y);
            PQ.offer( x + y);
        }

        long res = 0;
        for (long num : PQ)
            res += num;

        System.out.println(res);
    }
}
