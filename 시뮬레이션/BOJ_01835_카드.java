/**
 * BOJ : 1835 S4 카드
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_01835_카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 0; i < N; i++)
            Q.offer(i);

        int idx = 1;
        int[] res = new int[N];
        while (!Q.isEmpty()) {
            for (int i = 0; i < idx; i++)
                Q.offer(Q.poll());

            int num = Q.poll();
            res[num] = idx++;
        }

        for (int i = 0; i < N; i++)
            sb.append(res[i]).append(" ");

        System.out.println(sb);
    }
}
