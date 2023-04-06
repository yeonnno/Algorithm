/**
 * BOJ : 2469 G5 사다리 타기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02469_사다리타기 {

    static int K, N;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        char A = 'A';
        char[] startAlpha = new char[K];
        for (int i = 0; i < K; i++) {
            startAlpha[i] = A++;
        }

        char[] endAlpha = br.readLine().toCharArray();

        map = new char[N][K - 1];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // ? 가 나오는 위치 탐색
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (map[i][0] == '?') {
                idx = i;
                break;
            }
        }

        // 위에서부터
        for (int i = 0; i < idx; i++) {
            for (int j = 0; j < K - 1; j++) {
                if (map[i][j] == '-') {
                    char temp = startAlpha[j];
                    startAlpha[j] = startAlpha[j + 1];
                    startAlpha[j + 1] = temp;
                }
            }
        }

        // 아래서부터
        for (int i = N - 1; i > idx; i--) {
            for (int j = 0; j < K - 1; j++) {
                if (map[i][j] == '-') {
                    char temp = endAlpha[j];
                    endAlpha[j] = endAlpha[j + 1];
                    endAlpha[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < K - 1; i++) {
            if (startAlpha[i] == endAlpha[i]) {
                sb.append('*');
            } else if (startAlpha[i + 1] == endAlpha[i]) {
                sb.append('-');

                // 다음 비교를 위해 바꿔줘야함
                char temp = startAlpha[i];
                startAlpha[i] = startAlpha[i + 1];
                startAlpha[i + 1] = temp;
            } else {
                for (int j = 0; j < K - 1; j++) {
                    System.out.print('x');
                }
                System.exit(0);
            }
        }

        System.out.println(sb);
    }
}
