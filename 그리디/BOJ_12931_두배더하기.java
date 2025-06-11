/**
 * BOJ : 12931 G5 두 배 더하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12931_두배더하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int total = 0;
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        int res = 0;
        while (total != 0) {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                if (arr[i] % 2 == 1) {
                    arr[i]--;
                    cnt++;
                }
            }

            if (cnt > 0) {
                total -= cnt;
                res += cnt;
            } else {
                for (int i = 0; i < N; i++)
                    arr[i] /= 2;

                total /= 2;
                res++;
            }
        }

        System.out.println(res);
    }
}
