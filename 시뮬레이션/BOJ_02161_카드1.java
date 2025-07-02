/**
 * BOJ : 2161 S5 카드1
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_02161_카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            Q.offer(i);

        while (Q.size() != 1) {
            sb.append(Q.poll()).append(" ");
            Q.offer(Q.poll());
        }

        sb.append(Q.poll());

        System.out.println(sb);
    }
}
