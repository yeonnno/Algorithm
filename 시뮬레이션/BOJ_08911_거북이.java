/**
 * BOJ : 8911 S3 거북이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_08911_거북이 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int len = s.length();

            int x = 0, y = 0, dir = 0;
            int minX = 0, minY = 0, maxX = 0, maxY = 0;
            for (int i = 0; i < len; i++) {
                char com = s.charAt(i);

                if (com == 'F') {
                    x += dx[dir];
                    y += dy[dir];
                } else if (com == 'B') {
                    x -= dx[dir];
                    y -= dy[dir];
                } else if (com == 'L') {
                    if (dir == 0) dir = 3;
                    else dir--;
                } else if (com == 'R') {
                    if (dir == 3) dir = 0;
                    else dir++;
                }

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
            }

            sb.append((Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY))).append("\n");
        }

        System.out.print(sb);
    }
}
