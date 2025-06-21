/**
 * BOJ : 11971 S5 속도 위반
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11971_속도위반 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[100];

        int idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = idx; j < idx + x; j++)
                arr[j] = y;

            idx += x;
        }

        idx = 0;
        int res = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = idx; j < idx + x; j++)
                res = Math.max(res, y - arr[j]);

            idx += x;
        }

        System.out.println(res);
    }
}
