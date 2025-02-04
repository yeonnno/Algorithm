/**
 * BOJ : 16935 G5 배열 돌리기 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16935_배열돌리기3 {

    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            int op = Integer.parseInt(st.nextToken());
            int tmp;

            switch (op) {
                case 1:
                    operation1();
                    break;
                case 2:
                    operation2();
                    break;
                case 3:
                    operation3();
                    tmp = N;
                    N = M;
                    M = tmp;
                    break;
                case 4:
                    operation4();
                    tmp = N;
                    N = M;
                    M = tmp;
                    break;
                case 5:
                    operation5();
                    break;
                case 6:
                    operation6();
                    break;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void operation1() {
        for (int i = 0; i < N / 2; i++) {
            int[] tmp = Arrays.copyOf(arr[N - i - 1], M);

            arr[N - i - 1] = arr[i];
            arr[i] = tmp;
        }
    }

    private static void operation2() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = tmp;
            }
        }
    }

    private static void operation3() {
        int[][] tmp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N - i - 1] = arr[i][j];
            }
        }

        arr = tmp;
    }

    private static void operation4() {
        int[][] tmp = new int[M][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[M - j - 1][i] = arr[i][j];
            }
        }

        arr = tmp;
    }

    private static void operation5() {
        int[][] tmp = new int[N][M];

        change(0, 0, 0, M / 2, tmp);
        change(0, M / 2, N / 2, M / 2, tmp);
        change(N / 2, M / 2, N / 2, 0, tmp);
        change(N / 2, 0, 0, 0, tmp);

        arr = tmp;
    }

    private static void operation6() {
        int[][] tmp = new int[N][M];

        change(0, 0, N / 2, 0, tmp);
        change(N / 2, 0, N / 2, M / 2, tmp);
        change(N / 2, M / 2, 0, M / 2, tmp);
        change(0, M / 2, 0, 0, tmp);

        arr = tmp;
    }

    private static void change(int x1, int y1, int x2, int y2, int[][] tmp) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tmp[x2 + i][y2 + j] = arr[x1 + i][y1 + j];
            }
        }
    }
}
