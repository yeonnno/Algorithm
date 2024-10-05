/**
 * BOJ : 15961 G4 회전 초밥
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961_회전초밥 {

    static int N, D, K, C, res;
    static int[] sushi, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushi = new int[N];
        for (int i = 0; i < N; i++)
            sushi[i] = Integer.parseInt(br.readLine());

        int cnt = 1;
        count = new int[D + 1];
        count[C] = 3001;
        for (int i = 0; i < K; i++) {
            int x = sushi[i];

            if (count[x] == 0)
                cnt++;

            count[x]++;
        }

        res = cnt;

        for (int i = 0; i < N - 1; i++) {
            int start = sushi[i];
            int end = sushi[i + K < N ? i + K : (i + K) % N];

            count[start]--;
            if (count[start] == 0)
                cnt--;

            count[end]++;
            if (count[end] == 1)
                cnt++;

            res = Math.max(res, cnt);
        }

        System.out.println(res);
    }
}
