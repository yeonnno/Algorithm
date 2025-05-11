/**
 * BOJ : 1080 S1 행렬
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01080_행렬 {

    static int N, M, res;
    static int[][] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                A[i][j] = s.charAt(j) - '0';
        }

        B = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++)
                B[i][j] = s.charAt(j) - '0';
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 2 < N && j + 2 < M && A[i][j] != B[i][j]) {
                    convertMatrix(i, j);
                    res++;
                }
            }
        }

        if (check()) System.out.println(res);
        else System.out.println(-1);
    }

    private static boolean check() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j])
                    return false;
            }
        }
        return true;
    }

    private static void convertMatrix(int x, int y) {
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++)
                A[i][j] ^= 1;
        }
    }
}
