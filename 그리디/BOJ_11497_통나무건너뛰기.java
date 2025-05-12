/**
 * BOJ : 11497 S1 통나무 건너뛰기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11497_통나무건너뛰기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr);

            int[] tmp = new int[N];
            int left = 0, right = N - 1;
            for (int i = 0; i < N; i++) {
                if (i % 2 == 0) {
                    tmp[left] = arr[i];
                    left++;
                } else {
                    tmp[right] = arr[i];
                    right--;
                }
            }

            int res = Math.abs(tmp[0] - tmp[N - 1]);
            for (int i = 1; i < N; i++)
                res = Math.max(res, Math.abs(tmp[i] - tmp[i - 1]));

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
