/**
 * BOJ : 6236 S2 용돈 관리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_06236_용돈관리 {

    static int N, M, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int left = 0, right = 10000 * 100000;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, arr[i]);
        }

        res = 0;
        while (left <= right) {
            int mid = (left + right) / 2; // 인출 할 금액

            if (getCount(mid) <= M) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    private static int getCount(int mid) {
        int cnt = 1;
        int money = mid;

        for (int a : arr) {
            money -= a;

            if (money < 0) {
                cnt++;
                money = mid - a;
            }
        }

        return cnt;
    }
}
