/**
 * BOJ : 10597 S1 순열장난
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10597_순열장난 {

    static int N;
    static int[] res;
    static String str;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        int len = str.length();

        if (len < 10) {
            N = len;
            res = new int[N];
            visited = new boolean[N + 1];
        } else {
            N = 9 + (len - 9) / 2;
            res = new int[N];
            visited = new boolean[N + 1];
        }

        flag = false;
        backtrack(0, 0);
    }

    private static void backtrack(int depth, int idx) {
        if (depth >= N) {
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
            flag = true;
            return;
        }

        if (flag) return;

        int one = str.charAt(idx) - '0';
        if (one != 0 && !visited[one]) {
            visited[one] = true;
            res[depth] = one;
            backtrack(depth + 1, idx + 1);
            if (flag) return;
            visited[one] = false;
        }

        if (idx + 1 < str.length()) {
            int two = Integer.parseInt(str.substring(idx, idx + 2));

            if (two <= N && !visited[two]) {
                visited[two] = true;
                res[depth] = two;
                backtrack(depth + 1, idx + 2);
                if (flag) return;
                visited[two] = false;
            }
        }
    }
}
