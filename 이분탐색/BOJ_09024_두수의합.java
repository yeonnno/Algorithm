/**
 * BOJ : 9024 G5 두 수의 합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_09024_두수의합 {

    static int N, K, res, min;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            res = 0;
            min = Integer.MAX_VALUE;
            int left = 0, right = N - 1;
            while (left < right) {
                int sum = arr[left] + arr[right];
                int gap = Math.abs(sum - K);

                if (gap == min) {
                    res++;
                } else if (gap < min) {
                    min = gap;
                    res = 1;
                }

                if (sum >= K) right--;
                else left++;
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
