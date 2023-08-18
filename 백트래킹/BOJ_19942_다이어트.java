/**
 * BOJ : 19942 G5 다이어트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19942_다이어트 {

    static int N, res;
    static int[] nutrient, selected;
    static int[][] ingredient;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        nutrient = new int[4];
        for (int i = 0; i < 4; i++) {
            nutrient[i] = Integer.parseInt(st.nextToken());
        }

        ingredient = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ingredient[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        visited = new boolean[N];
        flag = false;

        backtrack(0, 0, 0, 0, 0, 0);

        if (flag) {
            sb.append(res).append("\n");
            for (int i = 0; i < N; i++) {
                if (selected[i] != 0) {
                    sb.append(selected[i]).append(" ");
                }
            }
            sb.append("\n");
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static void backtrack(int depth, int p, int f, int s, int v, int c) {
        if (p >= nutrient[0] && f >= nutrient[1] && s >= nutrient[2] && v >= nutrient[3]) {
            flag = true;

            if (res > c) {
                res = c;
                int idx = 0;
                selected = new int[N];
                for (int i = 0; i < N; i++) {
                    if (visited[i]) {
                        selected[idx++] = i+1;
                    }
                }
            }

            return;
        }

        if (depth == N) return;

        visited[depth] = true;
        backtrack(depth + 1, p + ingredient[depth][0], f + ingredient[depth][1], s + ingredient[depth][2], v + ingredient[depth][3], c + ingredient[depth][4]);
        visited[depth] = false;

        backtrack(depth + 1, p, f, s, v, c);
    }
}
