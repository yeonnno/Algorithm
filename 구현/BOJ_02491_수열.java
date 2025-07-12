/**
 * BOJ : 2491 S4 수열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02491_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int res = 1, inc = 1, dec = 1;
        for (int i = 1; i < N; i++) {
            if (arr[i] < arr[i - 1]) {
                inc = 1;
            } else {
                inc++;
            }

            if (arr[i] <= arr[i - 1]) {
                dec++;
            } else {
                dec = 1;
            }

            res = Math.max(res, Math.max(inc, dec));
        }

        System.out.println(res);
    }
}
