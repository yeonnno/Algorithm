/**
 * BOJ : 2303 S5 숫자 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02303_숫자게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] num = new int[5];
        int[] maxNum = new int[N + 1];
        for (int x = 1; x <= N; x++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 5; i++)
                num[i] = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 4; j++) {
                    for (int k = j + 1; k < 5; k++) {
                        sum = Math.max(sum, (num[i] + num[j] + num[k]) % 10);
                    }
                }
            }

            maxNum[x] = sum;
        }

        int res = 1, max = maxNum[1];
        for (int i = 2; i <= N; i++) {
            if (max <= maxNum[i]) {
                max = maxNum[i];
                res = i;
            }
        }

        System.out.println(res);
    }
}
