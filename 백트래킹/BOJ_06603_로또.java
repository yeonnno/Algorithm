/**
 * BOJ : 6603 S2 로또
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_06603_로또 {

    static int K;
    static int[] num, selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());

            K = Integer.parseInt(st.nextToken());

            if (K == 0) break;

            num = new int[K];
            for (int i = 0; i < K; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            selected = new int[6];
            backtrack(0, 0);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void backtrack(int depth, int pre) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(num[selected[i]]).append(" ");
            }
            sb.append("\n");
            return ;
        }

        for (int cur = pre; cur < K; cur++) {
            selected[depth] = cur;
            backtrack(depth + 1, cur + 1);
        }
    }
}
