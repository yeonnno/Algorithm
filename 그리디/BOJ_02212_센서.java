/**
 * BOJ : 2212 G5 센서
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02212_센서 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        if (K >= N) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++)
            diff[i] = arr[i + 1] - arr[i];

        Arrays.sort(diff);

        int res = 0;
        for (int i = 0; i < N - K; i++)
            res += diff[i];

        System.out.println(res);
    }
}
