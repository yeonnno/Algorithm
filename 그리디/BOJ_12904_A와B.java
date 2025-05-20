/**
 * BOJ : 12904 G5 A와 B
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder(br.readLine());
        StringBuilder T = new StringBuilder(br.readLine());
        int sLen = S.length();

        while (sLen < T.length()) {
            int tLen = T.length();

            if (T.charAt(tLen - 1) == 'A') {
                T.deleteCharAt(tLen - 1);
            } else {
                T.deleteCharAt(tLen - 1);
                T.reverse();
            }
        }

        System.out.println(S.toString().equals(T.toString()) ? 1 : 0);
    }
}
