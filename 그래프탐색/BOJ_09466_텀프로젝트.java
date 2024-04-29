/**
 * BOJ : 9466 G3 텀 프로젝트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_09466_텀프로젝트 {

    static int N, cnt;
    static int[] team;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            team = new int[N + 1];
            visited = new boolean[N + 1];
            finished = new boolean[N + 1];
            cnt = 0;

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                team[i] = Integer.parseInt(st.nextToken());

                if (team[i] == i) {
                    finished[i] = true;
                    cnt++;
                }
            }

            for (int i = 1; i <= N; i++) {
                if (finished[i]) continue;

                DFS(i);
            }

            sb.append(N - cnt).append("\n");
        }

        System.out.print(sb);
    }

    private static void DFS(int now) {
        if (finished[now]) return;

        if (visited[now]) {
            finished[now] = true;
            cnt++;
        }

        visited[now] = true;
        DFS(team[now]);
        finished[now] = true;
        visited[now] = false;
    }
}
