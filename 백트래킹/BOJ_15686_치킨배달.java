/**
 * BOJ : 15686 G5 치킨 배달
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_15686_치킨배달 {

    static int N, M, houseSize, chickenSize, res;
    static ArrayList<Point> house, chicken;
    static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        house = new ArrayList<>();
        chicken = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) house.add(new Point(i, j));
                else if (tmp == 2) chicken.add(new Point(i, j));
            }
        }

        res = Integer.MAX_VALUE;
        houseSize = house.size();
        chickenSize = chicken.size();
        selected = new boolean[chickenSize];

        backtrack(0, 0);

        System.out.println(res);
    }

    private static void backtrack(int depth, int pre) {
        if (depth == M) {
            int min = 0;

            for (int i = 0; i < houseSize; i++) {
                int dist = Integer.MAX_VALUE;

                for (int j = 0; j < chickenSize; j++) {
                    if (!selected[j]) continue;

                    int tmp = Math.abs(house.get(i).x - chicken.get(j).x) + Math.abs(house.get(i).y - chicken.get(j).y);
                    dist = Math.min(dist, tmp);
                }

                min += dist;
            }

            res = Math.min(res, min);

            return;
        }

        for (int i = pre; i < chickenSize; i++) {
            selected[i] = true;
            backtrack(depth + 1, i + 1);
            selected[i] = false;
        }
    }

    public static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
