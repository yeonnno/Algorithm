/**
 * BOJ : 21758 G5 꿀 따기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21758_꿀따기 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int l = left();
        int r = right();
        int m = mid();

        System.out.println(Math.max(l, Math.max(r, m)));
    }

    private static int left() {
        int[] sum = new int[N];

        for (int i = 1; i < N; i++)
            sum[i] = sum[i - 1] + arr[i - 1];

        int max = 0, end = sum[N - 1];
        for (int i = 0; i < N - 1; i++)
            max = Math.max(max, end - arr[i] + sum[i]);

        return max;
    }

    private static int right() {
        int[] sum = new int[N];

        for (int i = N - 2; i >= 0; i--)
            sum[i] = sum[i + 1] + arr[i + 1];

        int max = 0, end = sum[0];
        for (int i = 1; i < N; i++)
            max = Math.max(max, end - arr[i] + sum[i]);

        return max;
    }

    private static int mid() {
        int[] lSum = new int[N];
        int[] rSum = new int[N];

        for (int i = 1; i < N; i++)
            lSum[i] = lSum[i - 1] + arr[i];

        for (int i = N - 2; i >= 0; i--)
            rSum[i] = rSum[i + 1] + arr[i];

        int max = 0;
        for (int i = 0; i < N; i++)
            max = Math.max(max, lSum[i] + rSum[i]);

        return max;
    }
}
