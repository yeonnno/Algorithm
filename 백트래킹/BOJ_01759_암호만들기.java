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
    static int[] selected;
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
        selected = new int[L];

        backtrack(0, 0);

        System.out.println(sb);
    }

    private static void backtrack(int depth, int pre) {
        if (depth == L) {
            int cnt = 0;
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < L; i++) {
                char c = ch[selected[i]];
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') cnt++;
                tmp.append(c);
            }

            if (cnt >= 1 && L - cnt >= 2) sb.append(tmp).append("\n");

            return;
        }

        for (int i = pre; i < C; i++) {
            selected[depth] = i;
            backtrack(depth + 1, i + 1);
        }
    }
}
