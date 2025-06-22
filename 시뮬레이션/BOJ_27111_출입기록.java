/**
 * BOJ : 27111 S5 출입 기록
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_27111_출입기록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int res = 0, len = 0;
        boolean[] check = new boolean[200001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (y == 0) {
                if (check[x]) check[x] = false;
                else res++;
            } else {
                if (check[x]) res++;
                else check[x] = true;
            }

            len = Math.max(len, x);
        }

        for (int i = 1; i <= len; i++)
            if (check[i]) res++;

        System.out.println(res);
    }
}
