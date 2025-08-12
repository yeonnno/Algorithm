/**
 * BOJ : 2210 S2 숫자판 점프
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_02210_숫자판점프 {

    static String[][] map;
    static HashSet<String> set;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new String[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(0, i, j, map[i][j]);
            }
        }

        System.out.println(set.size());
    }

    private static void DFS(int depth, int x, int y, String str) {
        if (depth == 5) {
            set.add(str);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (!isPossible(nx, ny)) continue;

            DFS(depth + 1, nx, ny, str + map[nx][ny]);
        }
    }

    private static boolean isPossible(int nx, int ny) {
        return nx >= 0 && nx < 5 && ny >= 0 && ny < 5;
    }
}
