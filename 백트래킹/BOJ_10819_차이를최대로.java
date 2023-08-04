/**
 * BOJ : 10819 S2 차이를 최대로
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10819_차이를최대로 {

    static int N, res;
    static int[] num, selected;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[N];
        visited = new boolean[N];
        res = Integer.MIN_VALUE;
        backtrack(0);

        System.out.println(res);
    }

    private static void backtrack(int depth) {
        if (depth == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(num[selected[i]] - num[selected[i + 1]]);
            }

            res = Math.max(res, sum);
            return;
        }

        for (int cur = 0; cur < N; cur++) {
            if (visited[cur]) continue;

            visited[cur] = true;
            selected[depth] = cur;
            backtrack(depth + 1);
            visited[cur] = false;
        }
    }
}
