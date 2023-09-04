/**
 * BOJ : 1062 G4 가르침
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01062_가르침 {

    static int N, K, res;
    static String[] word;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        word = new String[N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            str = str.replace("anta", "");
            str = str.replace("tica", "");

            word[i] = str;
        }

        if (K < 5) {
            System.out.println(0);
        } else if (K == 26) {
            System.out.println(N);
        } else {
            res = 0;
            visited = new boolean[26];
            visited['a' - 'a'] = true;
            visited['c' - 'a'] = true;
            visited['i' - 'a'] = true;
            visited['n' - 'a'] = true;
            visited['t' - 'a'] = true;

            backtrack(0, 0);

            System.out.println(res);
        }
    }

    private static void backtrack(int depth, int pre) {
        if (depth == K - 5) {
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                boolean check = true;
                int len = word[i].length();

                for (int j = 0; j < len; j++) {
                    if (visited[word[i].charAt(j) - 'a']) continue;

                    check = false;
                    break;
                }

                if (check) cnt++;
            }

            res = Math.max(res, cnt);

            return;
        }

        for (int i = pre; i < 26; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            backtrack(depth + 1, i);
            visited[i] = false;
        }
    }
}
