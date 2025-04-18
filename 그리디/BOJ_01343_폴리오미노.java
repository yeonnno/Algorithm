/**
 * BOJ : 1343 S5 폴리오미노
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01343_폴리오미노 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine() + '.';
        int len = str.length();

        int cnt = 0;
        boolean check = true;
        for (int i = 0; i < len; i++) {
            char ch = str.charAt(i);

            if (ch == 'X') {
                cnt++;
            } else {
                if (cnt % 2 != 0) {
                    check = false;
                    break;
                }

                while (cnt > 0) {
                    if (cnt >= 4) {
                        cnt -= 4;
                        sb.append("AAAA");
                    } else {
                        cnt -= 2;
                        sb.append("BB");
                    }
                }

                sb.append(".");
            }
        }

        if (check) {
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb);
        } else{
            System.out.println(-1);
        }
    }
}
