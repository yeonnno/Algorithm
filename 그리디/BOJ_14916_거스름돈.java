/**
 * BOJ : 14916 S5 거스름돈
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916_거스름돈 {

    static int N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        res = 0;

        while (true) {
            if (N < 0) {
                res = -1;
                break;
            }

            if (N % 5 == 0) {
                res += N / 5;
                break;
            } else {
                N -= 2;
                res++;
            }
        }

        System.out.println(res);
    }
}
