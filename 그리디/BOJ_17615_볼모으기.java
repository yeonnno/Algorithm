/**
 * BOJ : 17615 S1 볼 모으기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_17615_볼모으기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        char[] ball = s.toCharArray();
        int redCnt = 0, blueCnt = 0;
        for (int i = 0; i < N; i++) {
            if (ball[i] == 'R')
                redCnt++;
            else
                blueCnt++;
        }

        int res = Integer.MAX_VALUE;

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (ball[i] == 'R')
                cnt++;
            else
                break;
        }
        res = Math.min(res, redCnt - cnt);

        cnt = 0;
        for (int i = 0; i < N; i++) {
            if (ball[i] == 'B')
                cnt++;
            else
                break;
        }
        res = Math.min(res, blueCnt - cnt);

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (ball[i] == 'R')
                cnt++;
            else
                break;
        }
        res = Math.min(res, redCnt - cnt);

        cnt = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (ball[i] == 'B')
                cnt++;
            else
                break;
        }
        res = Math.min(res, blueCnt - cnt);

        System.out.println(res);
    }
}
