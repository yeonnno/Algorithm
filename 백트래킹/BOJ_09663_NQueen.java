/**
 * BOJ : 9663 G4 N-Queen
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_09663_NQueen {

    static int N, res;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N];
        res = 0;

        backtrack(0);

        System.out.println(res);
    }

    private static void backtrack(int row) {
        if (row == N) {
            res++;
            return;
        }

        for (int i = 0; i < N; i++) {
            map[row] = i;

            if (isPossible(row)) {
                backtrack(row + 1);
            }
        }
    }

    private static boolean isPossible(int row) {
        for (int i = 0; i < row; i++) {
            if (map[row] == map[i]) return false;
            else if (Math.abs(map[row] - map[i]) == Math.abs(row - i)) return false;
        }
        return true;
    }
}
