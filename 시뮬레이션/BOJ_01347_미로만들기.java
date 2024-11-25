/**
 * BOJ : 1347 S2 미로 만들기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_01347_미로만들기 {

    static int N;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String s = br.readLine();
        int len = s.length();

        map = new char[100][100];
        for (int i = 0; i < 100; i++)
            Arrays.fill(map[i], '#');

        int x = 50, y = 50, dir = 2;
        int minX = 50, minY = 50, maxX = 50, maxY = 50;

        map[x][y] = '.';

        for (int i = 0; i < len; i++) {
            char comm = s.charAt(i);

            if (comm == 'F') {
                x += dx[dir];
                y += dy[dir];

                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);

                map[x][y] = '.';
            } else if (comm == 'L') {
                dir = dir == 0 ? 3 : dir - 1;
            } else if (comm == 'R') {
                dir = (dir + 1) % 4;
            }
        }

        for (int i = minX; i <= maxX; i++) {
            for (int j = minY; j <= maxY; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
