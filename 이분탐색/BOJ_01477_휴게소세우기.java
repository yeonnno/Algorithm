/**
 * BOJ : 1477 G4 휴게소 세우기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01477_휴게소세우기 {

    static int N, M, L;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        arr[0] = 0;
        arr[N + 1] = L;
        Arrays.sort(arr);

        int left = 1, right = L - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;

            for (int i = 1; i < N + 2; i++) {
                sum += (arr[i] - arr[i - 1] - 1) / mid;
            }

            if (sum > M) left = mid + 1;
            else right = mid - 1;
        }

        System.out.println(left);
    }
}
