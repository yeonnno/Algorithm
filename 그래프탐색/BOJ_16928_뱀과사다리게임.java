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
    static int[] map, check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[101];
        for (int i = 1; i <= 100; i++) {
            map[i] = i;
        }

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        check = new int[101];
        BFS(1);

        System.out.println(check[100]);
    }

    private static void BFS(int start) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(start);

        while (!Q.isEmpty()) {
            int now = Q.poll();

            for (int i = 1; i <= 6; i++) {
                int next = now + i;

                if (next > 100) continue;

                if (check[map[next]] == 0) {
                    Q.add(map[next]);
                    check[map[next]] = check[now] + 1;
                }

                if (map[next] == 100) {
                    return;
                }
            }
        }
    }
}
