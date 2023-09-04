/**
 * BOJ : 2580 G4 스도쿠
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02580_스도쿠 {

    static int[][] map;
    static boolean flag;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        flag = false;
        backtrack(0, 0);

        System.out.println(sb);
    }

    private static void backtrack(int x, int y) {
        if (flag) return;

        if (y == 9) {
            backtrack(x + 1, 0);
            return;
        }

        if (x == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }

            flag = true;

            return;
        }

        if (map[x][y] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (!isPossible(x, y, i)) continue;
                
                map[x][y] = i;
                backtrack(x, y + 1);
                map[x][y] = 0;
            }
            return;
        }

        backtrack(x, y + 1);
    }

    private static boolean isPossible(int x, int y, int n) {
        for (int i = 0; i < 9; i++) {
            if (map[x][i] == n) return false;
            if (map[i][y] == n) return false;
        }

        int nx = x / 3 * 3;
        int ny = y / 3 * 3;
        for (int i = nx; i < nx + 3; i++) {
            for (int j = ny; j < ny + 3; j++) {
                if (map[i][j] == n) return false;
            }
        }

        return true;
    }
}
