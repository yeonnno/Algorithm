/**
 * BOJ : 1244 S4 스위치 켜고 끄기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01244_스위치켜고끄기 {

    static int N, M;
    static boolean[] swi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        swi = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 1)
                swi[i] = true;
        }

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (s == 1) { // 남학생
                int idx = 1;
                while (true) {
                    int x = num * idx;

                    if (x > N) break;

                    swi[x] = !swi[x];
                    idx++;
                }
            } else { // 여학생
                int left = num, right = num;
                while (true) {
                    if (left - 1 < 1 || right + 1 > N) break;
                    if (swi[left - 1] != swi[right + 1]) break;

                    left--;
                    right++;
                }

                for (int j = left; j <= right; j++)
                    swi[j] = !swi[j];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (swi[i]) sb.append("1 ");
            else sb.append("0 ");

            if (i % 20 == 0) sb.append("\n");
        }

        System.out.print(sb);
    }
}
