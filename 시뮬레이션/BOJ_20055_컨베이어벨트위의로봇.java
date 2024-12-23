/**
 * BOJ : 20055 G5 컨베이어 벨트 위의 로봇
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

    static int N, K, res;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        belt = new int[N * 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++)
            belt[i] = Integer.parseInt(st.nextToken());

        robot = new boolean[N];

        res = 0;
        while (checkZero()) {
            // 1. 벨트, 로봇 함께 회전
            int tmp = belt[N * 2 - 1];
            for (int i = N * 2 - 1; i > 0; i--)
                belt[i] = belt[i - 1];
            belt[0] = tmp;

            for (int i = N - 1; i > 0; i--)
                robot[i] = robot[i - 1];
            robot[0] = false;
            robot[N - 1] = false;

            // 2. 로봇 한칸 이동
            for (int i = N - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && belt[i] > 0) {
                    robot[i] = true;
                    robot[i - 1] = false;
                    belt[i]--;
                }
            }

            // 3. 올리는 위치에 로봇 올리기
            if (belt[0] > 0) {
                belt[0]--;
                robot[0] = true;
            }

            res++;
        }

        System.out.println(res);
    }

    private static boolean checkZero() {
        int cnt = 0;
        for (int i = 0; i < N * 2; i++) {
            if (belt[i] == 0) cnt++;

            if (cnt >= K) return false;
        }
        return true;
    }
}
