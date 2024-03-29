/**
 * BOJ : 13908 S2 비밀번호
 */
import java.util.Scanner;

public class BOJ_13908_비밀번호 {

    static int N, M, res;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        visited = new boolean[10];
        for (int i = 0; i < M; i++) {
            visited[sc.nextInt()] = true;
        }

        res = 0;
        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int cnt) {
        if (depth == N) {
            if (cnt == M) res++;
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (visited[i]) {
                visited[i] = false;
                backtrack(depth + 1, cnt + 1);
                visited[i] = true;
            } else
                backtrack(depth + 1, cnt);
        }
    }
}
