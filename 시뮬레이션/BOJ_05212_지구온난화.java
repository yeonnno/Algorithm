/**
 * BOJ : 5212 S2 지구 온난화
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_05212_지구온난화 {

    static int N, M;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int minX = N, maxX = 0, minY = M, maxY = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'X') {
                    int cnt = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (isPossible(nx, ny)) {
                            if (map[nx][ny] == '.')
                                cnt++;
                        } else {
                            cnt++;
                        }
                    }

                    if (cnt >= 3)
                        map[i][j] = 'Z';
                }

                if (map[i][j] == 'X') {
                    minX = Math.min(minX, i);
                    maxX = Math.max(maxX, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                if (map[i][j] == 'X')
                    sb.append("X");
                else
                    sb.append(".");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx < N && nx >= 0 && ny < M && ny >= 0) return true;
        else return false;
    }
}
