/**
 * BOJ : 4659 S5 비밀번호 발음하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_04659_비밀번호발음하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String str = br.readLine();

            if (str.equals("end"))
                break;

            char[] arr = str.toCharArray();
            boolean check = false;
            char prev = '.';
            int cnt = 0;

            for (char ch : arr) {
                if (isVowel(ch)) check = true;

                if (isVowel(ch) != isVowel(prev))
                    cnt = 1;
                else
                    cnt++;

                if (cnt > 2 || (prev == ch && (ch != 'e' && ch != 'o'))) {
                    check = false;
                    break;
                }

                prev = ch;
            }

            sb.append("<").append(str);
            if (check)
                sb.append("> is acceptable.\n");
            else
                sb.append("> is not acceptable.\n");
        }

        System.out.print(sb);
    }

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
