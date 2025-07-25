/**
 * BOJ : 12871 S5 무한 문자열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12871_무한문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        int sLen = S.length(), tLen = T.length();
        int lcm = LCM(Math.min(sLen, tLen), Math.max(sLen, tLen));

        StringBuilder ss = new StringBuilder(S);
        for (int i = 0; i < lcm / sLen - 1; i++)
            ss.append(S);

        StringBuilder tt = new StringBuilder(T);
        for (int i = 0; i < lcm / tLen - 1; i++)
            tt.append(T);

        System.out.println(ss.toString().equals(tt.toString()) ? 1 : 0);
    }

    private static int LCM(int a, int b) {
        int A = a, B = b;

        while (b != 0) {
            a %= b;

            int tmp = a;
            a = b;
            b = tmp;
        }

        return A * B / a;
    }
}
