/**
 * BOJ : 15658 S2 연산자 끼워넣기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15658_연산자끼워넣기2 {

    static int N, max, min, res;
    static int[] num, op;
    static int[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        selected = new int[N - 1];
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        backtrack(0);

        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    private static void backtrack(int depth) {
        if (depth == N - 1) {
            res = num[0];
            for (int i = 1; i < N; i++) {
                calc(selected[i-1], num[i]);
            }

            max = Math.max(res, max);
            min = Math.min(res, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) continue;

            op[i]--;
            selected[depth] = i;
            backtrack(depth + 1);
            op[i]++;
        }
    }

    private static void calc(int op, int num) {
        switch (op) {
            case 0:
                res += num;
                break;
            case 1:
                res -= num;
                break;
            case 2:
                res *= num;
                break;
            case 3:
                res /= num;
                break;
        }
    }
}
