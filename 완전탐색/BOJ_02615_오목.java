package Brute_force;
/**
 * BOJ : 02615 S1 오목
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02615_오목 {

    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int startX, startY, endX, endY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        board = new int[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int resColor = 0;
        boolean flag = false;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (board[i][j] == 0) continue;
                else if (board[i][j] == 1) {
                    if (checkFive(i, j, 1)) {
                        resColor = 1;
                        startX = i + 1;
                        startY = j + 1;
                        flag = true;
                    }
                } else if (board[i][j] == 2) {
                    if (checkFive(i, j, 2)) {
                        resColor = 2;
                        startX = i + 1;
                        startY = j + 1;
                        flag = true;
                    }
                }

                if (flag) break;
            }
            if (flag) break;
        }

        int resX = startX;
        int resY = startY;

        if (startY < endY) {
            resX = startX;
            resY = startY;
        } else if (startY > endY) {
            resX = endX;
            resY = endY;
        } else {
            if (startX < endX) {
                resX = startX;
                resY = startY;
            } else if (startX > endX) {
                resX = endX;
                resY = endY;
            }
        }

        System.out.println(resColor);
        if (resColor != 0) {
            System.out.println(resX + " " + resY);
        }
    }

    private static boolean checkFive(int x, int y, int color) {
        int cnt = 0;
        for (int d = 0; d < 8; d++) {
            cnt = 0;
            int nx = x;
            int ny = y;

            while (true) {
                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != color) break;

                nx += dx[d];
                ny += dy[d];
            }

            while (true) {
                nx -= dx[d];
                ny -= dy[d];

                if (nx < 0 || nx >= 19 || ny < 0 || ny >= 19 || board[nx][ny] != color) break;

                cnt++;
            }

            if (cnt == 5) {
                endX = nx+dx[d]+1;
                endY = ny+dy[d]+1;
                return true;
            }
        }

        return false;
    }
}
