/**
 * BOJ : 1715 G4 카드 정렬하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_01715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++)
            PQ.offer(Integer.parseInt(br.readLine()));

        int res = 0;
        while (PQ.size() != 1) {
            int x = PQ.poll();
            int y = PQ.poll();

            res += x + y;

            PQ.offer(x + y);
        }

        System.out.println(res);
    }
}
