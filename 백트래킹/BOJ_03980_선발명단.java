/**
 * BOJ : 3980 G5 선발 명단
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03980_선발명단 {

    static int C, res;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        C = Integer.parseInt(br.readLine());
        for (int c = 0; c < C; c++) {
            map = new int[11][11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            visited = new boolean[11];

            backtrack(0, 0);

            sb.append(res).append("\n");
        }
        System.out.println(sb);
    }

    private static void backtrack(int depth, int sum) {
        if (depth == 11) {
            res = Math.max(res, sum);
            return;
        }

        for (int i = 0; i < 11; i++) {
            if (visited[i] || map[depth][i] == 0) continue;

            visited[i] = true;
            backtrack(depth + 1, sum + map[depth][i]);
            visited[i] = false;
        }
    }
}
