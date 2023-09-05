/**
 * BOJ : 2661 G4 좋은수열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02661_좋은수열 {

    static int N;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        flag = false;

        backtrack(0, "");
    }

    private static void backtrack(int depth, String num) {
        if (flag) return;

        if (depth == N) {
            System.out.println(num);
            flag = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (!isPossible(num + i)) continue;

            backtrack(depth + 1, num + i);
        }
    }

    private static boolean isPossible(String str) {
        int len = str.length();
        int half = len / 2;

        for (int i = 1; i <= half; i++) {
            String a = str.substring(len - i, len);
            String b = str.substring(len - i - i, len - i);

            if (a.equals(b)) return false;
        }

        return true;
    }
}
