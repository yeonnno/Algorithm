/**
 * BOJ : 19942 G5 다이어트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19942_다이어트 {

    static int N, res;
    static int[] nutrients, selected;
    static int[][] ingredients;
    static boolean[] visited;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        nutrients = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            nutrients[i] = Integer.parseInt(st.nextToken());
        }

        ingredients = new int[N][5];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                ingredients[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        visited = new boolean[N];
        flag = false;

        backtrack(0, 0, 0, 0, 0, 0);

        if (flag) {
            sb.append(res).append("\n");
            for (int i = 0; i < N; i++) {
                if (selected[i] != 0)
                    sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            sb.append(-1).append("\n");
        }

        System.out.println(sb);
    }

    private static void backtrack(int depth, int p, int f, int s, int v, int c) {
        if (p >= nutrients[0] && f >= nutrients[1] && s >= nutrients[2] && v >= nutrients[3]) {
            flag = true;

            if (res > c) {
                res = c;

                int idx = 0;
                selected = new int[N];
                for (int i = 0; i < N; i++) {
                    if (visited[i]) selected[idx++] = i+1;
                }
            }
            return;
        }

        if (depth == N) return;

        visited[depth] = true;
        backtrack(depth + 1, p + ingredients[depth][0], f + ingredients[depth][1], s + ingredients[depth][2], v + ingredients[depth][3], c + ingredients[depth][4]);
        visited[depth] = false;

        backtrack(depth + 1, p, f, s, v, c);
    }
}
