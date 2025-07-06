/**
 * BOJ : 1769 S5 3의 배수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01769_3의배수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String X = br.readLine();

        int res = 0, len = X.length();
        while (len != 1) {
            long sum = 0;

            for (int i = 0; i < len; i++)
                sum += Long.parseLong(String.valueOf(X.charAt(i)));

            X = String.valueOf(sum);
            len = X.length();

            res++;
        }

        sb.append(res).append("\n");
        if (Long.parseLong(X) % 3 == 0)
            sb.append("YES");
        else
            sb.append("NO");

        System.out.println(sb);
    }
}
