/**
 * BOJ : 15831 G4 준표의 조약돌
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15831_준표의조약돌 {

    static int N, B, W, res;
    static char[] stone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        stone = new char[N];
        String s = br.readLine();
        for (int i = 0; i < N; i++)
            stone[i] = s.charAt(i);

        res = 0;
        int start = 0, end = 0, bCnt = 0, wCnt = 0, len = 0;
        while (end < N) {
            if (bCnt > B) {
                if (stone[start] == 'W')
                    wCnt--;
                else
                    bCnt--;

                len--;
                start++;
            } else {
                if (stone[end] == 'W')
                    wCnt++;
                else
                    bCnt++;

                len++;
                end++;
            }

            if (bCnt <= B && wCnt >= W)
                res = Math.max(res, len);
        }

        System.out.println(res);
    }
}
