/**
 * BOJ : 1806 G4 부분합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01806_부분합 {

    static int N, S, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        res = N;
        boolean check = false;
        int start = 0, end = 0, sum = arr[0], cnt = 1;
        while (true) {
            if (sum < S) {
                end++;

                if (end >= N) break;

                sum += arr[end];
                cnt++;
            } else {
                check = true;
                res = Math.min(res, cnt);

                sum -= arr[start];
                start++;
                cnt--;

                if (start >= N) break;
            }
        }

        if (check) System.out.println(res);
        else System.out.println(0);
    }
}
