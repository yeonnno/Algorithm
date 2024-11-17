/**
 * BOJ : 14594 S4 동방 프로젝트 Small
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14594_동방프로젝트Small {

    static int N, M, res;
    static boolean[] room;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        room = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int j = x; j < y; j++)
                room[j] = true;
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            if (!room[i]) res++;
        }

        System.out.println(res);
    }
}
