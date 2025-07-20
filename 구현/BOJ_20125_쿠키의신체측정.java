/**
 * BOJ : 20125 S4 쿠키의 신체 측정
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_20125_쿠키의신체측정 {

    static int N, bx, by;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        map = new char[N + 1][N + 1];
        int heartX = 0, heartY = 0;
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                map[i][j] = s.charAt(j - 1);

                if (map[i][j] == '*' && (heartX == 0 && heartY == 0)) {
                    heartX = i + 1;
                    heartY = j;
                }
            }
        }

        sb.append(heartX).append(" ").append(heartY).append("\n");

        int leftArm = count(heartX, heartY, 0, -1);
        int rightArm = count(heartX, heartY, 0, 1);

        int body = count(heartX, heartY, 1, 0);

        int bodyX = bx, bodyY = by;
        int leftLeg = count(bodyX, bodyY - 1, 1, 0) + 1;
        int rightLeg = count(bodyX, bodyY + 1, 1, 0) + 1;

        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(body).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }

    private static int count(int x, int y, int dx, int dy) {
        int cnt = 0;

        while (true) {
            x += dx;
            y += dy;

            if (!isPossible(x, y) || map[x][y] != '*')
                break;

            cnt++;
        }

        bx = x;
        by = y;

        return cnt;
    }

    private static boolean isPossible(int x, int y) {
        return x > 0 && x <= N && y > 0 && y <= N;
    }
}
