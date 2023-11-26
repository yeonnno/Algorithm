/**
 * BOJ : 6236 S2 용돈 관리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_06236_용돈관리 {

    static int N, M, res;
    static int[] pay;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int left = 0;
        pay = new int[N];
        for (int i = 0; i < N; i++) {
            pay[i] = Integer.parseInt(br.readLine());
            left = Math.max(left, pay[i]);
        }

        res = 0;
        int right = 10000 * 100000;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (M >= getCount(mid)) {
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

        for (int p : pay) {
            money -= p;

            if (money < 0) {
                cnt++;
                money = mid - p;
            }
        }

        return cnt;
    }
}
