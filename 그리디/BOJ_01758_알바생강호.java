/**
 * BOJ : 1758 S4 알바생 강호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class BOJ_01758_알바생강호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr, Collections.reverseOrder());

        long res = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] - i > 0)
                res += arr[i] - i;
            else
                break;
        }

        System.out.println(res);
    }
}
