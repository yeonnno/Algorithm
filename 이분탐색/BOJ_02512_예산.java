/**
 * BOJ : 2512 S2 예산
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02512_예산 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0, right = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, arr[i]);
        }

        M = Integer.parseInt(br.readLine());

        while (left <= right) {
            int mid = (left + right) / 2; // 상한액
            long budget = 0;

            for (int a : arr) {
                if (a > mid) budget += mid;
                else budget += a;
            }

            if (budget <= M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(right);
    }
}
