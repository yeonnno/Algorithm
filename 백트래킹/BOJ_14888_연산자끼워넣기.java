/**
 * BOJ : 14888 S1 연산자 끼워넣기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

    static int N, max, min, tmp;
    static int[] num, op, selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

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

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        selected = new int[N - 1];

        backtrack(0);

        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    private static void backtrack(int depth) {
        if (depth == N - 1) {
            tmp = num[0];
            for (int i = 0; i < N - 1; i++) {
                calc(selected[i], num[i + 1]);
            }

            max = Math.max(max, tmp);
            min = Math.min(min, tmp);

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

    private static void calc(int op, int n) {
        switch (op) {
            case 0:
                tmp += n;
                break;
            case 1:
                tmp -= n;
                break;
            case 2:
                tmp *= n;
                break;
            case 3:
                tmp /= n;
                break;
        }
    }
}
