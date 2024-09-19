/**
 * BOJ : 20922 S1 겹치는 건 싫어
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {

    static int N, K, res;
    static int[] num, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        res = 0;
        int start = 0, end = 0;
        count = new int[100001];
        while (end < N) {
            while (end < N && count[num[end]] + 1 <= K) {
                count[num[end]]++;
                end++;
            }

            res = Math.max(res, end - start);

            count[num[start]]--;
            start++;
        }

        System.out.println(res);
    }
}
