/**
 * BOJ : 17266 S4 어두운 굴다리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17266_어두운굴다리 {

    static int N, M, res;
    static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        location = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1, right = N;
        res = 0;

        while (left <= right) {
            int mid = (left + right) / 2; // 높이가 기준

            if (check(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(res);
    }

    private static boolean check(int height) {
        int pre = 0;

        for (int loc : location) {
            // 가로등이 있는 위치에서 높이를 뺴면 가로등이 비추는 최소값을 알 수 있음
            // 최소값을 기준으로 가로등이 빈 곳 없이 다 비추는지 확인
            if (loc - height <= pre) {
                pre = loc + height;
            } else {
                return false;
            }
        }

        // 마지막 지점 확인
        return N - pre <= 0;
    }
}
