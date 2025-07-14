/**
 * BOJ : 2567 S4 색종이 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02567_색종이2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[101][101];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    map[a][b] = 1;
                }
            }
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        int res = 0;
        for (int x = 0; x <= 100; x++) {
            for (int y = 0; y <= 100; y++) {

                for (int d = 0; d < 2; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (isPossible(nx, ny) && map[x][y] != map[nx][ny])
                        res++;

                }
            }
        }

        System.out.println(res);
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100;
    }
}
