/**
 * BOJ : 26215 S3 눈 치우기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_26215_눈치우기 {

    static int N, res;
    static PriorityQueue<Integer> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        PQ = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            PQ.offer(Integer.parseInt(st.nextToken()));

        res = 0;
        while (true) {
            int x = PQ.poll();

            if (PQ.isEmpty()) {
                res += x;
                break;
            }

            int y = PQ.poll();

            res += y;
            PQ.offer(x - y);
        }

        if (res > 1440) System.out.println(-1);
        else System.out.println(res);
    }
}
