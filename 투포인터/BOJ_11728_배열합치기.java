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

        int pointA = 0, pointB = 0;
        while (pointA < N && pointB < M) {
            if (A[pointA] <= B[pointB])
                sb.append(A[pointA++]).append(" ");
            else
                sb.append(B[pointB++]).append(" ");
        }

        if (pointA != N) {
            for (int i = pointA; i < N; i++)
                sb.append(A[i]).append(" ");
        }

        if (pointB != M) {
            for (int i = pointB; i < M; i++)
                sb.append(B[i]).append(" ");
        }

        System.out.println(sb);
    }
}
