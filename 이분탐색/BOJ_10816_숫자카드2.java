/**
 * BOJ : 10816 S4 숫자 카드 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {

    static int N, M, cnt;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        card = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            cnt = upper(num) - lower(num);

            sb.append(cnt).append(" ");
        }

        System.out.print(sb);
    }

    private static int upper(int num) {
        int left = 0, right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (card[mid] > num) right = mid;
            else left = mid + 1;
        }

        return left;
    }

    private static int lower(int num) {
        int left = 0, right = N;

        while (left < right) {
            int mid = (left + right) / 2;

            if (card[mid] >= num) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
