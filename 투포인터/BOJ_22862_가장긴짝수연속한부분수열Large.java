/**
 * BOJ : 22862 G5 가장 긴 짝수 연속한 부분 수열 large
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22862_가장긴짝수연속한부분수열Large {

    static int N, K, res;
    static boolean[] even;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        even = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            even[i] = x % 2 == 0;
        }

        res = 0;
        int start = 0, end = 0, oddCnt = 0;
        while (end < N) {
            if (oddCnt < K) { // 홀수 개수가 K개 미만일 때
                if (!even[end])
                    oddCnt++;

                end++;
                res = Math.max(res, end - start - oddCnt);
            } else { // 홀수 개수가 K개를 채웠을 때
                if (even[end]) {
                    end++;
                    res = Math.max(res, end - start - oddCnt);
                } else {
                    // start를 이동시키기 위해 짝수인지 홀수인지 체크
                    if (!even[start])
                        oddCnt--;

                    start++;
                }
            }
        }

        System.out.println(res);
    }
}
