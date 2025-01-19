/**
 * BOJ : 17281 G4 야구공
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17281_야구공 {

    static int N, res;
    static int[][] player;
    static int[] selected;
    static boolean[] visited, base;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        player = new int[N + 1][10];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 9; j++) {
                player[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 0;
        selected = new int[10];
        visited = new boolean[10];

        selected[4] = 1;
        visited[4] = true;

        permutation(2);

        System.out.println(res);
    }

    private static void permutation(int depth) {
        if (depth == 10) {
            play();
            return;
        }

        for (int cur = 1; cur <= 9; cur++) {
            if (visited[cur]) continue;

            visited[cur] = true;
            selected[cur] = depth;
            permutation(depth + 1);
            visited[cur] = false;
        }
    }

    private static void play() {
        int idx = 1, sum = 0;

        for (int i = 1; i <= N; i++) {
            int score = 0, out = 0;

            base = new boolean[4];

            while (out < 3) {
                switch (player[i][selected[idx]]) {
                    case 0:
                        out++;
                        break;
                    case 1:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            base[3] = true;
                            base[2] = false;
                        }
                        if (base[1]) {
                            base[2] = true;
                            base[1] = false;
                        }
                        base[1] = true;

                        break;
                    case 2:
                        if (base[3]) {
                            score++;
                            base[3] = false;
                        }
                        if (base[2]) {
                            score++;
                        }
                        if (base[1]) {
                            base[3] = true;
                            base[1] = false;
                        }
                        base[2] = true;

                        break;
                    case 3:
                        if (base[3]) {
                            score++;
                        }
                        if (base[2]) {
                            score++;
                            base[2] = false;
                        }
                        if (base[1]) {
                            score++;
                            base[1] = false;
                        }
                        base[3] = true;

                        break;
                    case 4:
                        for (int j = 3; j >= 1; j--) {
                            if (base[j]) {
                                score++;
                                base[j] = false;
                            }
                        }
                        score++;

                        break;
                }

                idx++;
                if (idx > 9) idx = 1;
            }

            sum += score;
        }

        res = Math.max(res, sum);
    }
}
