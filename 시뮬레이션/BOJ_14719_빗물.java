/**
 * BOJ : 14719 G5 빗물
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719_빗물 {

    static int H, W, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        res = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;

            for (int j = 0; j < i; j++)
                left = Math.max(left, arr[j]);

            for (int j = i + 1; j < W; j++)
                right = Math.max(right, arr[j]);

            if (Math.min(left, right) > arr[i])
                res += Math.min(left, right) - arr[i];
        }

        System.out.println(res);
    }
}
