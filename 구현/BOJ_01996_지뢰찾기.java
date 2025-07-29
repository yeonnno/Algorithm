/**
 * BOJ : 1996 S5 지뢰 찾기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01996_지뢰찾기 {

    static int N;
    static char[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    int cnt = count(i, j);

                    if (cnt < 10)
                        sb.append(cnt);
                    else
                        sb.append('M');

                } else {
                    sb.append('*');
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static int count(int x, int y) {
        int cnt = 0;

        for (int d = 0; d < 8; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isPossible(nx, ny)) continue;

            if (map[nx][ny] != '.')
                cnt += map[nx][ny] - '0';
        }

        return cnt;
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < N && ny >= 0 && ny < N;
    }
}
