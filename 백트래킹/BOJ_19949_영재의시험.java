/**
 * BOJ : 19949 S2 영재의 시험
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19949_영재의시험 {

    static int res;
    static int[] solution, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        solution = new int[10];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        res = 0;
        answer = new int[10];
        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int score) {
        if (10 - depth + score < 5) {
            return;
        }

        if (depth == 10) {
            if (score >= 5) res++;
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (answer[depth-2] == i && answer[depth-1] == i) continue;
            }

            answer[depth] = i;

            if (solution[depth] == answer[depth]) {
                backtrack(depth + 1, score + 1);
            } else {
                backtrack(depth + 1, score);
            }
        }
    }
}
