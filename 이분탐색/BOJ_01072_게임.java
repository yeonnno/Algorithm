/**
 * BOJ : 1072 G3 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01072_게임 {

    static int X, Y, Z, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = getAvg(X, Y);

        res = -1;
        int left = 0, right = 1_000_000_000;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getAvg(X + mid, Y + mid) != Z) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    private static int getAvg(int x, int y) {
        return (int) ((long) y * 100 / x);
    }
}
