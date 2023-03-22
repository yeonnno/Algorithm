/**
 * BOJ : 2661 G4 좋은수열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02661_좋은수열 {

    static int N;
    static boolean isEnd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        isEnd = false;
        backtrack("");
    }

    private static void backtrack(String num) {
        if (isEnd) return;

        if (num.length() == N) {
            System.out.println(num);
            isEnd = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (check(num + i)) {
                backtrack(num + i);
            }
        }
    }

    private static boolean check(String str) {
        int half = str.length() / 2;

        for (int i = 1; i <= half; i++) {
            String a = str.substring(str.length() - i, str.length());
            String b = str.substring(str.length() - i - i, str.length() - i);

            if (a.equals(b)) {
                return false;
            }
        }
        return true;
    }
}
