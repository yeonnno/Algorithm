/**
 * BOJ : 9009 S1 피보나치
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_09009_피보나치 {

    static int[] fiboArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        fibo();

        Stack<Integer> stack = new Stack<>();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 45; i > 0; i--) {
                if (fiboArr[i] <= N) {
                    N -= fiboArr[i];
                    stack.push(fiboArr[i]);
                }

                if (N == 0) break;
            }

            while (!stack.isEmpty())
                sb.append(stack.pop()).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void fibo() {
        fiboArr = new int[46];
        fiboArr[1] = 1;

        for (int i = 2; i < 46; i++)
            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
    }
}
