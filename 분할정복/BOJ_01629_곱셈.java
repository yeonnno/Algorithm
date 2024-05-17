/**
 * BOJ : 1629 S1 곱셈
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01629_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B, C));
    }

    private static long pow(int a, int b, int c) {
        if (b == 0)
            return 1;

        long n = pow(a, b / 2, c);

        if (b % 2 == 0)
            return n * n % c;
        else
            return (n * n % c) * a % c;
    }
}
