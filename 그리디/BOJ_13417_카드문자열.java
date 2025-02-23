/**
 * BOJ : 13417 S3 카드 문자열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_13417_카드문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder res = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            char[] arr = new char[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = st.nextToken().charAt(0);

            Deque<Character> DQ = new LinkedList<>();
            DQ.offer(arr[0]);

            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < N; i++) {
                char now = arr[i];

                if (now <= DQ.peek()) {
                    DQ.offerFirst(now);
                } else {
                    DQ.offerLast(now);
                }
            }

            for (char ch : DQ)
                sb.append(ch);

            res.append(sb).append("\n");
        }

        System.out.print(res);
    }
}
