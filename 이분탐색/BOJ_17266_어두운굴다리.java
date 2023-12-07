/**
 * BOJ : 17266 S4 어두운 굴다리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266_어두운굴다리 {

    static int N, M, res;
    static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        location = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = N;
        res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (check(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    private static boolean check(int mid) {
        int prev = 0;

        for (int loc : location) {
            if (loc - mid <= prev) {
                prev = loc + mid;
            } else {
                return false;
            }
        }

        return N - prev <= 0;
    }
}
