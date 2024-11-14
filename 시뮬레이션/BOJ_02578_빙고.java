/**
 * BOJ : 2578 S4 빙고
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02578_빙고 {

    static int res;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = 1;
        boolean flag = false;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());

                deleteNum(num);

                if (checkBingo() >= 3) {
                    flag = true;
                    break;
                }

                res++;
            }
            if (flag) break;
        }

        System.out.println(res);
    }

    private static int checkBingo() {
        int cnt = 0;

        // 가로 세로
        for (int i = 0; i < 5; i++) {
            int row = 0, col = 0;

            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0)
                    row++;

                if (map[j][i] == 0)
                    col++;
            }

            if (row == 5)
                cnt++;

            if (col == 5)
                cnt++;
        }

        // 대각선
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][i] == 0)
                zero++;
        }

        if (zero == 5)
            cnt++;

        zero = 0;
        for (int i = 0; i < 5; i++) {
            if (map[i][4 - i] == 0)
                zero++;
        }

        if (zero == 5)
            cnt++;

        return cnt;
    }

    private static void deleteNum(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == num) {
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }
}
