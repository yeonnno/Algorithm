/**
 * BOJ : 10815 S5 숫자 카드
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10815_숫자카드 {

    static int N, M;
    static int[] card;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuffer sb = new StringBuffer();

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
            int left = 0, right = N - 1;
            boolean check = false;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (card[mid] > num) {
                    right = mid - 1;
                } else if (card[mid] < num) {
                    left = mid + 1;
                } else {
                    check = true;
                    break;
                }
            }

            if (check) sb.append(1);
            else sb.append(0);
            sb.append(" ");
        }

        System.out.print(sb);
    }
}
