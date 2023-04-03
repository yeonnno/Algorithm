/**
 * BOJ : 16719 G5 ZOAC
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16719_ZOAC {

    static StringBuilder sb;
    static String str;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        str = br.readLine();
        visited = new boolean[str.length()];

        backtrack(0, str.length() - 1);

        System.out.println(sb);
    }

    private static void backtrack(int s, int e) {
        if (s > e) {
            return;
        } else {
            int idx = s;

            for (int i = s; i <= e; i++) {
                if (str.charAt(idx) > str.charAt(i)) {
                    idx = i;
                }
            }

            visited[idx] = true;
            for (int i = 0; i < str.length(); i++) {
                if (visited[i]) {
                    sb.append(str.charAt(i));
                }
            }
            sb.append("\n");

            backtrack(idx + 1, e);
            backtrack(s, idx - 1);
        }
    }
}
