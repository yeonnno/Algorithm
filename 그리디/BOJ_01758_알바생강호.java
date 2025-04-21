/**
 * BOJ : 1758 S4 알바생 강호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_01758_알바생강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long res = 0;
        int idx = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (arr[i] - idx >= 0)
                res += arr[i] - idx;
            idx++;
        }

        System.out.println(res);
    }
}
