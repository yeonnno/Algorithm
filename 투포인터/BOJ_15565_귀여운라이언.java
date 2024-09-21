/**
 * BOJ : 15565 S1 귀여운 라이언
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15565_귀여운라이언 {

    static int N, K, res;
    static ArrayList<Integer> lion;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        lion = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (x == 1) lion.add(i);
        }

        int size = lion.size();

        if (size < K) {
            System.out.println(-1);
        } else {
            res = 1000001;
            int start = 0, end = K - 1;

            while (end != size) {
                int cnt = lion.get(end) - lion.get(start) + 1;
                res = Math.min(res, cnt);

                start++;
                end++;
            }

            System.out.println(res);
        }
    }
}
