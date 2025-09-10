/**
 * BOJ : 16928 G5 뱀과 사다리 게임
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928_뱀과사다리게임 {

    static int N, M;
    static int[] map, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[101];
        for (int i = 1; i < 101; i++)
            map[i] = i;

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        res = new int[101];

        BFS();

        System.out.println(res[100]);
    }

    private static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int d = 1; d <= 6; d++) {
                int next = now + d;

                if (next > 100) break;

                if (res[map[next]] == 0) {
                    res[map[next]] = res[now] + 1;
                    Q.offer(map[next]);
                }

                if (res[next] == 100)
                    return;
            }
        }
    }
}
