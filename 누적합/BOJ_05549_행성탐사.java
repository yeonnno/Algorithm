/**
 * BOJ : 5549 G5 행성 탐사
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_05549_행성탐사 {

    static int N, M, K;
    static int[][][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        map = new int[3][N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= M; j++) {
                char ch = s.charAt(j - 1);
                switch (ch) {
                    case 'J':
                        map[0][i][j] = 1;
                        break;
                    case 'O':
                        map[1][i][j] = 1;
                        break;
                    case 'I':
                        map[2][i][j] = 1;
                        break;
                }
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= M; j++) {
                    map[k][i][j] += map[k][i - 1][j];
                }
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    map[k][i][j] += map[k][i][j - 1];
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = 0; j < 3; j++) {
                int res = map[j][x2][y2] - map[j][x1 - 1][y2] - map[j][x2][y1 - 1] + map[j][x1 - 1][y1 - 1];
                sb.append(res).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
