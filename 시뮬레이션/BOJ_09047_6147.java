/**
 * BOJ : 9047 S5 6147
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_09047_6147 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int res = 0;
            while (N != 6174) {
                int[] num = new int[4];

                for (int i = 0; i < 4; i++) {
                    num[i] = N % 10;
                    N /= 10;
                }

                Arrays.sort(num);

                int min = 0, max = 0;
                for (int i = 0; i < 4; i++) {
                    min = min * 10 + num[i];
                    max = max * 10 + num[3 - i];
                }

                N = max - min;
                res++;
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
