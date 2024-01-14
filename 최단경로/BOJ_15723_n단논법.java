/**
 * BOJ : 15723 S1 n단 논법
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15723_n단논법 {

    static int N, M;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new boolean[26][26];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            adj[s.charAt(0) - 'a'][s.charAt(s.length() - 1) - 'a'] = true;
        }

        floyd();

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String s = br.readLine();

            if (adj[s.charAt(0) - 'a'][s.charAt(s.length() - 1) - 'a']) sb.append('T');
            else sb.append('F');
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][k] && adj[k][j]) adj[i][j] = true;
                }
            }
        }
    }
}
