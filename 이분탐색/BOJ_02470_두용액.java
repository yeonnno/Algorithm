/**
 * BOJ : 2470 G5 두 용액
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02470_두용액 {

    static int N, min, res1, res2;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        res1 = res2 = 0;
        min = Integer.MAX_VALUE;
        int left = 0, right = N - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);

                res1 = arr[left];
                res2 = arr[right];

                if (sum == 0) break;
            }

            if (sum < 0) left++;
            else right--;
        }

        sb.append(res1).append(" ").append(res2);
        System.out.println(sb);
    }
}
