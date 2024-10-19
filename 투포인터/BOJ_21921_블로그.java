/**
 * BOJ : 21921 S3 블로그
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_21921_블로그 {

    static int N, X, sum, max, res;
    static int[] visitor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        visitor = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            visitor[i] = Integer.parseInt(st.nextToken());

        sum = 0;
        for (int i = 0; i < X; i++)
            sum += visitor[i];

        res = 1;
        max = sum;
        int start = 0, end = X;
        while (end < N) {
            sum -= visitor[start++];
            sum += visitor[end++];

            if (max < sum) {
                max = sum;
                res = 1;
            } else if (max == sum) {
                res++;
            }
        }

        if (max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(res);
        }
    }
}
