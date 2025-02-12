/**
 * BOJ : 2217 S4 로프
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_02217_로프 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int res = -1;
        for (int i = 0; i < N; i++)
            res = Math.max(res, arr[i] * (N - i));

        System.out.println(res);
    }
}
