/**
 * BOJ : 1213 S3 팰린드롬 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01213_팰린드롬만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        int len = s.length();

        int[] alpha = new int[26];
        for (int i = 0; i < len; i++)
            alpha[s.charAt(i) - 'A']++;

        int oddCnt = 0;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 == 1)
                oddCnt++;
        }

        if (oddCnt > 1) {
            System.out.println("I'm Sorry Hansoo");
        } else {
            StringBuilder sb = new StringBuilder();
            StringBuilder tmp = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < alpha[i] / 2; j++) {
                    tmp.append((char) (i + 'A'));
                }
            }

            sb.append(tmp);

            for (int i = 0; i < 26; i++) {
                if (alpha[i] % 2 == 1)
                    sb.append((char) (i + 'A'));
            }

            sb.append(tmp.reverse());

            System.out.println(sb);
        }
    }
}
