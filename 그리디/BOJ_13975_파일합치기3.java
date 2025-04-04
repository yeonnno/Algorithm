/**
 * BOJ : 13975 G4 파일 합치기 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975_파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(br.readLine());

            PriorityQueue<Long> PQ = new PriorityQueue<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++)
                PQ.offer(Long.parseLong(st.nextToken()));

            long res = 0;
            while (PQ.size() != 1) {
                long x = PQ.poll();
                long y = PQ.poll();

                res += x + y;
                PQ.offer(x + y);
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
