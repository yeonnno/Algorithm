/**
 * BOJ : 1541 S2 잃어버린 괄호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");

        int res = Integer.MAX_VALUE;
        while (sub.hasMoreTokens()) {
            int tmp = 0;

            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");

            while (add.hasMoreTokens())
                tmp += Integer.parseInt(add.nextToken());

            if (res == Integer.MAX_VALUE)
                res = tmp;
            else
                res -= tmp;
        }

        System.out.println(res);
    }
}
