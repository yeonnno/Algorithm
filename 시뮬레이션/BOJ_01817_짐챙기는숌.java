/**
 * BOJ : 1817 S5 짐 챙기는 숌
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01817_짐챙기는숌 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (N == 0) {
            System.out.println(0);
        } else {
            int res = 1, box = M;
            st = new StringTokenizer(br.readLine());
            while (N > 0) {
                int now = Integer.parseInt(st.nextToken());

                if (box - now >= 0) {
                    box -= now;
                } else {
                    box = M - now;
                    res++;
                }

                N--;
            }

            System.out.println(res);
        }
    }
}
