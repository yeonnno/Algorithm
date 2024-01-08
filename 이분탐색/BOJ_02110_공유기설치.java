/**
 * BOJ : 2110 G4 공유기 설치
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_02110_공유기설치 {

    static int N, C, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        res = 0;
        int left = 1, right = arr[N - 1];
        while (left <= right) {
            int mid = (left + right) / 2;
            int idx = 0, cnt = 1;

            for (int i = 1; i < N; i++) {
                if (arr[i] - arr[idx] >= mid) {
                    idx = i;
                    cnt++;
                }
            }

            if (cnt >= C) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(res);
    }
}
