/**
 * BOJ : 3048 S4 개미
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_03048_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        char[] A = new char[N];
        for (int i = 0; i < N; i++)
            A[i] = s.charAt(N - i - 1);

        char[] B = br.readLine().toCharArray();

        char[] res = new char[N + M];
        int[] dir = new int[N + M];

        for (int i = 0; i < N; i++) {
            res[i] = A[i];
            dir[i] = 1;
        }

        for (int i = N; i < N + M; i++) {
            res[i] = B[i - N];
            dir[i] = -1;
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            for (int i = 0; i < N + M - 1; i++) {
                if (dir[i] == 1 && dir[i + 1] == -1) {
                    char ch = res[i];
                    res[i] = res[i + 1];
                    res[i + 1] = ch;

                    int tmp = dir[i];
                    dir[i] = dir[i + 1];
                    dir[i + 1] = tmp;

                    i++;
                }
            }
        }

        for (int i = 0; i < N + M; i++)
            sb.append(res[i]);

        System.out.println(sb);
    }
}
