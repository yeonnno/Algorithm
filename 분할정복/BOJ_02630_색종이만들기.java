/**
 * BOJ : 2630 S2 색종이 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02630_색종이만들기 {

    static int N;
    static int[] res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = new int[2];

        backtrack(0,0, N);

        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    private static void backtrack(int x, int y, int size) {
        if (checkOneColor(x, y, size)) {
            res[map[x][y]]++;
            return;
        }

        int mid = size / 2;

        backtrack(x, y, mid);
        backtrack(x, y + mid, mid);
        backtrack(x + mid, y, mid);
        backtrack(x + mid, y + mid, mid);
    }

    private static boolean checkOneColor(int x, int y, int mid) {
        int val = map[x][y];
        for (int i = x; i < x + mid; i++) {
            for (int j = y; j < y + mid; j++) {
                if (val != map[i][j]) return false;
            }
        }
        return true;
    }
}
