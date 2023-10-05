/**
 * BOJ : 15723 S1 n단 논법
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15723_n단논법 {

    static int N, M, INF = 999999999;
    static int[][] adj;
    static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new int[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == j) adj[i][j] = 0;
                else adj[i][j] = INF;
            }
        }

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            strArr = s.split(" is ");

            int a = strArr[0].charAt(0) - 'a';
            int b = strArr[1].charAt(0) - 'a';
            adj[a][b] = 1;
        }

        floyd();

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            strArr = s.split(" is ");

            int a = strArr[0].charAt(0) - 'a';
            int b = strArr[1].charAt(0) - 'a';

            if (adj[a][b] != 0 && adj[a][b] != INF) sb.append("T");
            else sb.append("F");

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void floyd() {
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][j] > adj[i][k] + adj[k][j]) {
                        adj[i][j] = adj[i][k] + adj[k][j];
                    }
                }
            }
        }
    }
}
