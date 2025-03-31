/**
 * BOJ : 1339 G4 단어 수학
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_01339_단어수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[26];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int len = s.length();

            for (int j = 0; j < len; j++) {
                char ch = s.charAt(j);

                arr[ch - 'A'] += (int) Math.pow(10, len - j - 1);
            }
        }

        Arrays.sort(arr);

        int res = 0, num = 9;
        for (int i = 25; i >= 0; i--) {
            if (arr[i] == 0) break;

            res += arr[i] * num;
            num--;
        }

        System.out.println(res);
    }
}
