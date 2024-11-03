/**
 * BOJ : 14921 G5 용액 합성하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14921_용액합성하기 {

    static int N, res;
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

        res = 0;
        int start = 0, end = N - 1, min = Integer.MAX_VALUE;
        while (start < end) {
            int sum = arr[start] + arr[end];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                res = sum;
            }

            if (sum == 0)
                break;
            else if (sum < 0)
                start++;
            else
                end--;
        }

        System.out.println(res);
    }
}
