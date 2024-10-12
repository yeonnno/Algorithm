/**
 * BOJ : 16472 G4 고냥이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16472_고냥이 {

    static int N, res;
    static int[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int len = s.length();

        res = 0;
        alpha = new int[26];
        int start = 0, end = 0, cnt = 0;
        while (end < len) {
            if (alpha[s.charAt(end) - 'a']++ == 0)
                cnt++;


            while (cnt > N && start < end) {
                if (--alpha[s.charAt(start++) - 'a'] == 0)
                    cnt--;
            }

            res = Math.max(res, end - start + 1);

            end++;
        }

        System.out.println(res);
    }
}
