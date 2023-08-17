/**
 * BOJ : 6443 G5 애너그램
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_06443_애너그램 {

    static int N, len;
    static char[] ch;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        for (int n = 0; n < N; n++) {
            ch = br.readLine().toCharArray();

            Arrays.sort(ch);

            len = ch.length;
            selected =  new int[len];
            visited = new boolean[len];

            backtrack(0);
        }
        System.out.println(sb);
    }

    private static void backtrack(int depth) {
        if (depth == len) {
            StringBuilder tmp = new StringBuilder();
            for (int i = 0; i < len; i++) {
                tmp.append(ch[selected[i]]);
            }

            sb.append(tmp).append("\n");
            return;
        }

        char before = '0';
        for (int i = 0; i < len; i++) {
            if (visited[i]) continue;
            if (before == ch[i]) continue;

            before = ch[i];

            visited[i] = true;
            selected[depth] = i;
            backtrack(depth + 1);
            visited[i] = false;
        }
    }
}
