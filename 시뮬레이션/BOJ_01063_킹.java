/**
 * BOJ : 1063 S3 킹
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01063_킹 {

    static int N;
    static Point king, stone;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        king = getPoint(st.nextToken());
        stone = getPoint(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int dir = getDir(s);
            int nx = king.x + dx[dir];
            int ny = king.y + dy[dir];

            if (!isPossible(nx, ny)) continue;

            if (nx == stone.x && ny == stone.y) {
                int snx = stone.x + dx[dir];
                int sny = stone.y + dy[dir];

                if (!isPossible(snx, sny)) continue;

                stone.x = snx;
                stone.y = sny;
            }

            king.x = nx;
            king.y = ny;
        }

        System.out.println(getResult(king));
        System.out.println(getResult(stone));
    }

    private static String getResult(Point p) {
        StringBuilder sb = new StringBuilder();

        int x = 9 - p.x;
        char y = (char) (p.y - 1 + 'A');

        sb.append(y).append(x);

        return sb.toString();
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 1 && nx <= 8 && ny >= 1 && ny <= 8) return true;
        else return false;
    }

    private static int getDir(String s) {
        if (s.equals("R"))
            return 0;
        else if (s.equals("L"))
            return 1;
        else if (s.equals("B"))
            return 2;
        else if (s.equals("T"))
            return 3;
        else if (s.equals("RT"))
            return 4;
        else if (s.equals("LT"))
            return 5;
        else if (s.equals("RB"))
            return 6;
        else if (s.equals("LB"))
            return 7;
        else
            return -1;
    }

    private static Point getPoint(String s) {
        int x = s.charAt(1) - '0';
        int y = s.charAt(0) - 'A';

        return new Point(9 - x, y + 1);
    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
