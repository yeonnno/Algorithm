/**
 * BOJ : 2828 S5 사과 담기 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02828_사과담기게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());

        int res = 0;
        int start = 1, end = M;
        for (int i = 0; i < J; i++) {
            int num = Integer.parseInt(br.readLine());

            if (start > num) {
                res += start - num;
                end -= start - num;
                start = num;
            } else if (end < num) {
                res += num - end;
                start += num - end;
                end = num;
            }
        }

        System.out.println(res);
    }
}
