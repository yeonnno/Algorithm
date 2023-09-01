/**
 * BOJ : 15659 G4 연산자 끼워넣기 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_15659_연산자끼워넣기3 {

    static int N, max, min;
    static int[] num, op, selected;

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
            int res = getResult();
            max = Math.max(max, res);
            min = Math.min(min, res);
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

    public static int getResult() {
        Deque<Integer> number = new ArrayDeque<>();
        Deque<Character> operator = new ArrayDeque<>();
        number.add(num[0]);

        for (int i = 0; i < N - 1; i++) {
            if (selected[i] == 0) {
                operator.add('+');
                number.add(num[i + 1]);
            } else if (selected[i] == 1) {
                operator.add('-');
                number.add(num[i + 1]);
            } else if (selected[i] == 2) {
                int tmp = number.pollLast() * num[i + 1];
                number.add(tmp);
            } else if (selected[i] == 3) {
                int tmp = number.pollLast() / num[i + 1];
                number.add(tmp);
            }
        }

        int n = number.pollFirst();
        int size = operator.size();
        for (int i = 0; i < size; i++) {
            char oper = operator.pollFirst();
            if (oper == '+') {
                n += number.pollFirst();
            } else if (oper == '-') {
                n -= number.pollFirst();
            }
        }

        return n;
    }
}
