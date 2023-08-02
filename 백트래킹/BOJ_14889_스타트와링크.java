/**
 * BOJ : 14889 S2 스타트와 링크
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14889_스타트와링크 {

    static int N, res;
    static int[][] S;
    static int[] teamA, teamB;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = Integer.MAX_VALUE;
        teamA = new int[N / 2];
        teamB = new int[N / 2];
        visited = new boolean[N];

        makeTeam(0, 0);

        System.out.println(res);
    }

    private static void makeTeam(int depth, int pre) {
        if (depth == N / 2) {
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                teamB[idx++] = i;
            }

            int a = calcScore(teamA);
            int b = calcScore(teamB);

            res = Math.min(res, Math.abs(a - b));

        } else {
            for (int i = pre; i < N; i++) {
                if (visited[i]) continue;

                visited[i] = true;
                teamA[depth] = i;
                makeTeam(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static int calcScore(int[] team) {
        int sum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < N / 2; j++) {
                if (i == j) continue;
                sum += S[team[i]][team[j]];
            }
        }
        return sum;
    }

}
