/**
 * BOJ : 15686 G5 치킨배달
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

    static int N, M, res;
    static int[][] map;
    static ArrayList<Point> house, chicken;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }

        res = Integer.MAX_VALUE;
        selected = new boolean[chicken.size()];
        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int cnt) {
        if (cnt == M) {
            int min = 0;

            for (int i = 0; i < house.size(); i++) {
                int dist = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (selected[j]) {
                        int tmp = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                        dist = Math.min(dist, tmp);
                    }
                }
                min += dist;
            }
            res = Math.min(res, min);

        } else {
            for (int cur = depth; cur < chicken.size(); cur++) {
                selected[cur] = true;
                backtrack(cur + 1, cnt + 1);
                selected[cur] = false;
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
