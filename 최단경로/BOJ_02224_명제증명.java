/**
 * BOJ : 2224 G4 명제 증명
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02224_명제증명 {

    static int N, res;
    static boolean[][] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        adj = new boolean[58][58];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split(" => ");
            int s = str[0].charAt(0) - 'A';
            int e = str[1].charAt(0) - 'A';

            adj[s][e] = true;
        }

        floyd();

        res = 0;
        for (int i = 0; i < 58; i++) {
            for (int j = 0; j < 58; j++) {
                if (i == j) continue;

                if (adj[i][j]) {
                    res++;

                    char c1 = (char) (i + 65);
                    char c2 = (char) (j + 65);

                    sb.append(c1).append(" => ").append(c2).append("\n");
                }
            }
        }

        System.out.println(res);
        System.out.print(sb);
    }

    private static void floyd() {
        for (int k = 0; k < 58; k++) {
            for (int i = 0; i < 58; i++) {
                for (int j = 0; j < 58; j++) {
                    if (i == j || j == k || k == i) continue;

                    if (adj[i][k] && adj[k][j]) adj[i][j] = true;
                }
            }
        }
    }
}
