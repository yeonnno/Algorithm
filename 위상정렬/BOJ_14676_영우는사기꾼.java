/**
 * BOJ : 14676 G3 영우는 사기꾼?
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_14676_영우는사기꾼 {

    static int N, M, K;
    static String res;
    static int[] indegree, buildCnt;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            adj[i] = new ArrayList<>();

        indegree = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            indegree[b]++;
        }

        buildCnt = new int[N + 1];
        res = "King-God-Emperor";

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int now = Integer.parseInt(st.nextToken());

            if (command == 1) {
                if (indegree[now] != 0) {
                    res = "Lier!";
                    break;
                }

                buildCnt[now]++;
                if (buildCnt[now] == 1) {
                    for (int next : adj[now])
                        indegree[next]--;
                }
            } else if (command == 2) {
                if (buildCnt[now] == 0) {
                    res = "Lier!";
                    break;
                }

                buildCnt[now]--;
                if (buildCnt[now] == 0) {
                    for (int next : adj[now])
                        indegree[next]++;
                }
            }
        }

        System.out.println(res);
    }
}
