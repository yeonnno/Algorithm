/**
 * BOJ : 1331 S4 나이트 투어
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01331_나이트투어 {

    static boolean check;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        check = true;
        map = new boolean[7][7];
        int startX = 0, startY = 0, prevX = 0, prevY = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String s = br.readLine();
                int nowY = s.charAt(0) - 'A' + 1;
                int nowX = s.charAt(1) - '0';

                if (!check) continue;

                if (map[nowX][nowY]) {
                    check = false;
                    continue;
                }

                map[nowX][nowY] = true;

                if (i == 0 && j == 0) {
                    startX = nowX;
                    startY = nowY;
                } else if (i == 5 && j == 5) {
                    if (!isPossible(startX, startY, nowX, nowY))
                        check = false;
                } else {
                    if (!isPossible(prevX, prevY, nowX, nowY))
                        check = false;
                }

                prevX = nowX;
                prevY = nowY;
            }
        }

        if (check) System.out.println("Valid");
        else System.out.println("Invalid");
    }

    private static boolean isPossible(int ax, int ay, int bx, int by) {
        int x = Math.abs(ax - bx);
        int y = Math.abs(ay - by);

        if ((x == 1 && y == 2) || (x == 2 && y == 1)) return true;
        else return false;
    }
}
