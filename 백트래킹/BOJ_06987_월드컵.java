/**
 * BOJ : 6987 G4 월드컵
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_06987_월드컵 {

    static int[][] matches, worldCup;
    static boolean isPossible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        matches = new int[15][2];
        int idx = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 6; j++) {
                matches[idx][0] = i;
                matches[idx][1] = j;
                idx++;
            }
        }

        for (int t = 0; t < 4; t++) {
            worldCup = new int[6][3];
            st = new StringTokenizer(br.readLine());
            boolean check = true;
            for (int i = 0; i < 6; i++) {
                worldCup[i][0] = Integer.parseInt(st.nextToken()); // 승
                worldCup[i][1] = Integer.parseInt(st.nextToken()); // 무
                worldCup[i][2] = Integer.parseInt(st.nextToken()); // 패

                if (worldCup[i][0] + worldCup[i][1] + worldCup[i][2] != 5) {
                    check = false;
                    break;
                }
            }

            if (check) {
                isPossible = false;

                backtrack(0);

                if (isPossible) sb.append(1);
                else sb.append(0);

            } else {
                sb.append(0);
            }

            sb.append(" ");
        }

        System.out.println(sb);
    }

    private static void backtrack(int depth) {
        if (isPossible) return;

        if (depth == 15) {
            isPossible = true;
            return;
        }

        int teamA = matches[depth][0];
        int teamB = matches[depth][1];

        // teamA 승, teamB 패
        if (worldCup[teamA][0] > 0 && worldCup[teamB][2] > 0) {
            worldCup[teamA][0]--;
            worldCup[teamB][2]--;

            backtrack(depth + 1);

            worldCup[teamA][0]++;
            worldCup[teamB][2]++;
        }

        // teamA 무, teamB 무
        if (worldCup[teamA][1] > 0 && worldCup[teamB][1] > 0) {
            worldCup[teamA][1]--;
            worldCup[teamB][1]--;

            backtrack(depth + 1);

            worldCup[teamA][1]++;
            worldCup[teamB][1]++;
        }

        // teamA 패, teamB 승
        if (worldCup[teamA][2] > 0 && worldCup[teamB][0] > 0) {
            worldCup[teamA][2]--;
            worldCup[teamB][0]--;

            backtrack(depth + 1);

            worldCup[teamA][2]++;
            worldCup[teamB][0]++;
        }
    }
}
