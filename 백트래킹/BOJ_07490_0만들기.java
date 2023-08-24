/**
 * BOJ : 7490 G5 0 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_07490_0만들기 {

    static int T, N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            backtrack(1, 0, 1, 1, "1");

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void backtrack(int depth, int sum, int num, int op, String str) {
        if (depth == N) {
            sum += num * op;
            if (sum == 0) sb.append(str).append("\n");
            return;
        }

        backtrack(depth + 1, sum, num * 10 + depth + 1, op, str + " " + (depth + 1));
        backtrack(depth + 1, sum + num * op, depth + 1, 1, str + "+" + (depth + 1));
        backtrack(depth + 1, sum + num * op, depth + 1, -1, str + "-" + (depth + 1));
    }
}
