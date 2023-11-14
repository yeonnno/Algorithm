/**
 * BOJ : 16139 S1 인간 컴퓨터 상호작용
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16139_인간컴퓨터상호작용 {

    static String str;
    static int Q, C, L, R;
    static int[][] preSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        str = br.readLine();
        int len = str.length();

        preSum = new int[len + 1][26];
        for (int i = 1; i <= len; i++) {
            int idx = str.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                preSum[i][j] = preSum[i - 1][j];
                if (j == idx) preSum[i][j]++;
            }
        }

        Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            C = st.nextToken().charAt(0) - 'a';
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            int res = preSum[R + 1][C] - preSum[L][C];
            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }
}
