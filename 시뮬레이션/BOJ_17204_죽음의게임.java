/**
 * BOJ : 17204 S3 죽음의 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17204_죽음의게임 {

    static int N, K, res;
    static int[] num;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        num = new int[N];
        for (int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        visited = new boolean[N];

        res = 0;
        int idx = 0;
        boolean check = true;
        for (int i = 0; i < N; i++) {
            if (idx == K) {
                res = i;
                break;
            }

            if (visited[idx]) {
                check = false;
                break;
            }

            visited[idx] = true;
            idx = num[idx];
        }

        if (check) System.out.println(res);
        else System.out.println(-1);
    }
}
