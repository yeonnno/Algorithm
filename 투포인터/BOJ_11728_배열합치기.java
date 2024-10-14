/**
 * BOJ : 11728 S5 배열 합치기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11728_배열합치기 {

    static int N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            B[i] = Integer.parseInt(st.nextToken());

        int x = 0, y = 0;
        while (x < N && y < M) {
            if (A[x] < B[y]) {
                sb.append(A[x]).append(" ");
                x++;
            } else {
                sb.append(B[y]).append(" ");
                y++;
            }
        }

        if (x != N) {
            for (int i = x; i < N; i++)
                sb.append(A[i]).append(" ");
        }

        if (y != M) {
            for (int i = y; i < M; i++)
                sb.append(B[i]).append(" ");
        }

        System.out.println(sb);
    }
}
