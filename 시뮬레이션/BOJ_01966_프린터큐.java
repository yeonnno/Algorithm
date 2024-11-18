/**
 * BOJ : 1966 S3 프린터 큐
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01966_프린터큐 {

    static int N, M, res;
    static Queue<Info> Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            Q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                Q.offer(new Info(i, Integer.parseInt(st.nextToken())));

            res = 0;
            while (!Q.isEmpty()) {
                Info now = Q.poll();
                boolean isMax = true;

                for (Info next : Q) {
                    if (now.cost < next.cost) {
                        isMax = false;
                        break;
                    }
                }

                if (isMax) {
                    res++;
                    if (now.x == M) break;
                } else {
                    Q.offer(now);
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    private static class Info {
        int x;
        int cost;

        public Info(int x, int cost) {
            this.x = x;
            this.cost = cost;
        }
    }
}
