/**
 * BOJ : 14921 G5 용액 합성하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14921_용액합성하기 {

    static int N, res;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        res = Integer.MAX_VALUE;
        int start = 0, end = N - 1;
        while (start < end) {
            int sum = num[start] + num[end];

            if (sum == 0) {
                res = 0;
                break;
            }

            if (Math.abs(res) > Math.abs(sum))
                res = sum;

            if (sum < 0) start++;
            else end--;
        }

        System.out.println(res);
    }
}
