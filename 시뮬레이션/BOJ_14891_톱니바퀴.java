/**
 * BOJ : 14891 G5 톱니바퀴
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14891_톱니바퀴 {

    static int K, res;
    static int[] dir;
    static boolean[][] gear;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        gear = new boolean[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                if (s.charAt(j) == '1')
                    gear[i][j] = true;
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int turn = Integer.parseInt(st.nextToken());

            dir = new int[4];
            dir[gearNum] = turn;

            checkDir(gearNum);
            turnDir();
        }

        res = 0;
        if (gear[0][0]) res += 1;
        if (gear[1][0]) res += 2;
        if (gear[2][0]) res += 4;
        if (gear[3][0]) res += 8;

        System.out.println(res);
    }

    private static void turnDir() {
        boolean tmp;
        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) {
                tmp = gear[i][7];
                for (int j = 7; j > 0; j--)
                    gear[i][j] = gear[i][j - 1];
                gear[i][0] = tmp;
            } else if (dir[i] == -1) {
                tmp = gear[i][0];
                for (int j = 0; j < 7; j++)
                    gear[i][j] = gear[i][j + 1];
                gear[i][7] = tmp;
            }
        }
    }

    private static void checkDir(int n) {
        for (int i = n - 1; i >= 0; i--) {
            if (gear[i][2] ^ gear[i + 1][6])
                dir[i] = -dir[i + 1];
            else
                break;
        }

        for (int i = n + 1; i < 4; i++) {
            if (gear[i][6] ^ gear[i - 1][2])
                dir[i] = -dir[i - 1];
            else
                break;
        }
    }
}
