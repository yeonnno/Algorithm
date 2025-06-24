/**
 * BOJ : 1417 S5 국회의원 선거
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ_01417_국회의원선거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()) - 1;
        int dasom = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> PQ = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++)
            PQ.offer(Integer.parseInt(br.readLine()));

        int res = 0;
        while (!PQ.isEmpty() && PQ.peek() >= dasom) {
            dasom++;
            PQ.offer(PQ.poll() - 1);

            res++;
        }

        System.out.println(res);
    }
}
