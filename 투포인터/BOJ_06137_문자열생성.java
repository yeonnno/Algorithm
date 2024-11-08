/**
 * BOJ : 6137 G4 문자열 생성
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_06137_문자열생성 {

    static int N;
    static char[] alpha;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        alpha = new char[N];
        for (int i = 0; i < N; i++)
            alpha[i] = br.readLine().charAt(0);

        int start = 0, end = N - 1, idx = 0;
        while (start <= end) {
            if (alpha[start] - '0' < alpha[end] - '0') {
                sb.append(alpha[start++]);
            } else if (alpha[start] - '0' > alpha[end] - '0') {
                sb.append(alpha[end--]);
            } else {
                int x = start, y = end;
                boolean check = true;

                while (alpha[x] == alpha[y]) {
                    if (x < N - 1) x++;
                    if (y > 0) y--;

                    if (alpha[x] - '0' < alpha[y] - '0') check = true;
                    else if (alpha[x] - '0' > alpha[y] - '0') check = false;
                }

                if (check) sb.append(alpha[start++]);
                else sb.append(alpha[end--]);
            }

            idx++;
            if (idx != 0 && idx % 80 == 0) sb.append("\n");
        }

        System.out.println(sb);
    }
}
