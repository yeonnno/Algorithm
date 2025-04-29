/**
 * BOJ : 20115 S3 에너지 드링크
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20115_에너지드링크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        double max = 0;
        double[] arr = new double[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        double res = max;
        for (int i = 0; i < N; i++) {
            if (max == arr[i])
                continue;

            res += arr[i] / 2;
        }

        System.out.println(res);
    }
}
