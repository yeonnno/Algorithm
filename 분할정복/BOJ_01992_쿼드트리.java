/**
 * BOJ : 1992 S1 쿼드트리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01992_쿼드트리 {

    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        backtrack(0, 0, N);

        System.out.println(sb);
    }

    private static void backtrack(int x, int y, int size) {
        if (check(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        sb.append("(");

        int mid = size / 2;

        backtrack(x, y, mid);
        backtrack(x, y + mid, mid);
        backtrack(x + mid, y, mid);
        backtrack(x + mid, y + mid, mid);

        sb.append(")");
    }

    private static boolean check(int x, int y, int size) {
        int val = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (val != map[i][j]) return false;
            }
        }
        return true;
    }
}
