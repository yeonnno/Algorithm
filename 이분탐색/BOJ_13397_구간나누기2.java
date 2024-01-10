/**
 * BOJ : 13397 G4 구간 나누기 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13397_구간나누기2 {

    static int N, M, res, INF = 999999999;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int left = 0, right = 0;

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        res = 0;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (getCnt(mid) <= M) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    private static int getCnt(int mid) {
        int cnt = 1;
        int min = INF;
        int max = -INF;

        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);

            if (max - min > mid) {
                cnt++;
                min = INF;
                max = -INF;
                i--;
            }
        }

        return cnt;
    }
}
