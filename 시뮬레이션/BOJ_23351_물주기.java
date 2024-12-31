/**
 * BOJ : 23351 S3 물 주기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_23351_물주기 {

    static int N, K, A, B, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = K;

        res = 0;
        while (true) {
            Arrays.sort(arr);

            if (arr[0] == 0) break;

            for (int i = 0; i < A; i++)
                arr[i] += B;

            for (int i = 0; i < N; i++)
                arr[i]--;

            res++;
        }

        System.out.println(res);
    }
}
