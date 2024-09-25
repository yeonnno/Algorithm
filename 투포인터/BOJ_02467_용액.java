/**
 * BOJ : 2467 G5 용액
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02467_용액 {

    static int N, min, res1, res2;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        res1 = res2 = 0;
        min = Integer.MAX_VALUE;
        int start = 0, end = N - 1;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (min > Math.abs(sum)) {
                res1 = arr[start];
                res2 = arr[end];

                min = Math.abs(sum);
            }

            if (sum < 0) start++;
            else end--;
        }

        System.out.println(res1 + " " + res2);
    }
}
