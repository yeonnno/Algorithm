/**
 * BOJ : 1759 G5 암호 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01759_암호만들기 {

    static int L, C;
    static char[] ch;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ch = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            ch[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(ch);
        visited = new boolean[C];

        backtrack(0, 0,  "");

        System.out.println(sb);
    }

    private static void backtrack(int depth, int pre, String str) {
        if (depth == L) {
            int vowel = 0;
            for (int i = 0; i < L; i++) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') vowel++;
            }

            if (vowel >= 1 && L - vowel >= 2) {
                sb.append(str).append("\n");
            }

            return;
        }

        for (int i = pre; i < C; i++) {
            backtrack(depth + 1, i + 1, str + ch[i]);
        }
    }
}
