/**
 * BOJ : 1074 S1 Z
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01074_Z {

    static int N, R, C, res;
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        res = 0;
        check = false;

        backtrack(R, C, N);

        System.out.println(res);
    }

    private static void backtrack(int x, int y, int size) {
        if (size == 1) return;

        int mid = size / 2;

        if (x < mid && y < mid) {
            res += mid * mid * 0;
            backtrack(x, y, mid);
        } else if (x < mid && y >= mid) {
            res += mid * mid * 1;
            backtrack(x, y - mid, mid);
        } else if (x >= mid && y < mid) {
            res += mid * mid * 2;
            backtrack(x - mid, y, mid);
        } else if (x >= mid && y >= mid) {
            res += mid * mid * 3;
            backtrack(x - mid, y - mid, mid);
        }
    }
}
