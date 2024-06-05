/**
 * BOJ : 3665 G1 최종 순위
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 순서가 미리 정해져있고, 순위의 선후관계만 바뀜 -> 각 순위마다 모든 관계를 추가해주어야 함.
 * 진입차수를 작년 순위에 맞게 초기화
 * 바뀐 순위의 선후관계에 맞게 연결리스트와 진입차수 수정
 * 진입차수가 0인 값이 1개보다 많으면 확실한 순위를 찾을 수 없는 것 -> "?" 출력
 * while문이 아닌 for문을 통해 위상정렬 알고리즘이 정상 동작하는지 확인
 * 1부터 N까지 돌기 전에 Queue가 비어버리면 비정상적으로 종료된 것 -> "IMPOSSIBLE" 출력
 * 정상 종료되면 1순위부터 N순위까지 출력
 */
public class BOJ_03665_최종순위 {

    static int N, M;
    static int[] rank, indegree, res;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            rank = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++)
                rank[i] = Integer.parseInt(st.nextToken());

            adj = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++)
                adj[i] = new ArrayList<>();

            indegree = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = i + 1; j <= N; j++) {
                    adj[rank[i]].add(rank[j]);
                    indegree[rank[j]]++;
                }
            }

            M = Integer.parseInt(br.readLine());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (adj[a].contains(b)) {
                    adj[a].remove(Integer.valueOf(b));
                    adj[b].add(a);
                    indegree[a]++;
                    indegree[b]--;
                } else {
                    adj[b].remove(Integer.valueOf(a));
                    adj[a].add(b);
                    indegree[b]++;
                    indegree[a]--;
                }
            }

            topologySort();
        }

        System.out.print(sb);
    }

    private static void topologySort() {
        Queue<Integer> Q = new LinkedList<>();

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                Q.offer(i);
                cnt++;
            }
        }

        if (cnt > 1) {
            sb.append("?\n");
            return;
        }

        res = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (Q.isEmpty()) {
                sb.append("IMPOSSIBLE\n");
                return;
            }

            int now = Q.poll();

            res[i] = now;

            for (int next : adj[now]) {
                indegree[next]--;

                if (indegree[next] == 0)
                    Q.offer(next);
            }
        }

        for (int i = 1; i <= N; i++)
            sb.append(res[i]).append(" ");
        sb.append("\n");
    }
}
