/**
 * BOJ : 11663 S3 선분 위의 점
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11663_선분위의점 {

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(upper(e) - lower(s)).append("\n");
        }

        System.out.print(sb);
    }

    private static int lower(int num) {
        int left = 0, right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private static int upper(int num) {
        int left = 0, right = N - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] <= num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }
}
