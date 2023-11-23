/**
 * BOJ : 2805 S2 나무 자르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02805_나무자르기 {

    static int N, M;
    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());

            if (right < num[i]) right = num[i];
        }

        while (left < right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int height : num) {
                if (height - mid > 0) sum += height - mid;
            }

            if (sum < M) right = mid;
            else left = mid + 1;
        }

        System.out.println(left - 1);
    }
}
