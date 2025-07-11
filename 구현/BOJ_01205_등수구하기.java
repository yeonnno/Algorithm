/**
 * BOJ : 1205 S4 등수 구하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01205_등수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(1);
            return;
        }

        int[] rank = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            rank[i] = Integer.parseInt(st.nextToken());

        if (N == P && score <= rank[N - 1]) {
            System.out.println(-1);
        } else {
            int res = 1;

            for (int i = 0; i < N; i++) {
                if (score < rank[i])
                    res++;
                else
                    break;
            }
            System.out.println(res);
        }
    }
}
