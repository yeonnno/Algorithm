/**
 * BOJ : 2195 G5 문자열 복사
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02195_문자열복사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int len = P.length();
        int res = 0, idx = 0;
        for (int i = 0; i < len; i++) {
            String sub = P.substring(idx, i + 1);

            if (S.indexOf(sub) == -1) {
                res++;
                idx = i;
            }
        }

        System.out.println(res + 1);
    }
}
