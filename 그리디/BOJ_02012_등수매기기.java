/**
 * BOJ : 2012 S3 등수 매기기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_02012_등수매기기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long res = 0;
        for (int i = 1; i <= N; i++)
            res += Math.abs(i - arr[i]);

        System.out.println(res);
    }
}
