/**
 * BOJ : 2023 G5 신기한 소수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02023_신기한소수 {

    static int N;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        backtrack(0, 2);
        backtrack(0, 3);
        backtrack(0, 5);
        backtrack(0, 7);

        System.out.println(sb);
    }

    private static void backtrack(int depth, int num) {
        if (depth == N - 1) {
            sb.append(num).append("\n");
            return;
        }

        for (int i = 1; i < 10; i += 2) {
            int tmp = num * 10 + i;

            if (isPrime(tmp)) {
                backtrack(depth + 1, tmp);
            }
        }
    }

    private static boolean isPrime(int n) {
        int sqrt = (int) Math.sqrt(n) + 1;
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
