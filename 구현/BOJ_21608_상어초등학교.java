/**
 * BOJ : 21608 G5 상어 초등학교
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_21608_상어초등학교 {

    static int N, res;
    static int[] student;
    static int[][] map;
    static ArrayList<Integer>[] likeList;
    static PriorityQueue<Point> PQ;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        likeList = new ArrayList[N * N + 1];
        for (int i = 0; i <= N * N; i++)
            likeList[i] = new ArrayList<>();

        student = new int[N * N + 1];
        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N * N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            student[i] = num;

            for (int j = 0; j < 4; j++)
                likeList[num].add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 1; i <= N * N; i++)
            setPlace(student[i]);

        res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                res += getSatisfaction(i, j);
            }
        }

        System.out.println(res);
    }

    private static int getSatisfaction(int x, int y) {
        int num = map[x][y];
        int cnt = 0;

        for (int now : likeList[num]) {
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (!isPossible(nx, ny)) continue;

                if (map[nx][ny] == now)
                    cnt++;
            }
        }

        if (cnt == 0) return 0;
        else if (cnt == 1) return 1;
        else if (cnt == 2) return 10;
        else if (cnt == 3) return 100;
        else return 1000;
    }

    private static void setPlace(int num) {
        PQ = new PriorityQueue<>();

        for (int x = 1; x <= N; x++) {
            for (int y = 1; y <= N; y++) {
                int likeCnt = 0, emptyCnt = 0;

                if (map[x][y] != 0) continue;

                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (!isPossible(nx, ny)) continue;

                    for (int now : likeList[num]) {
                        if (now == map[nx][ny])
                            likeCnt++;
                    }

                    if (map[nx][ny] == 0)
                        emptyCnt++;
                }

                PQ.offer(new Point(x, y, likeCnt, emptyCnt));
            }
        }

        Point p = PQ.poll();
        map[p.x][p.y] = num;

        PQ.clear();
    }

    private static boolean isPossible(int nx, int ny) {
        return nx > 0 && nx <= N && ny > 0 && ny <= N;
    }

    private static class Point implements Comparable<Point> {
        int x;
        int y;
        int likeCnt;
        int emptyCnt;

        public Point(int x, int y, int likeCnt, int emptyCnt) {
            this.x = x;
            this.y = y;
            this.likeCnt = likeCnt;
            this.emptyCnt = emptyCnt;
        }

        @Override
        public int compareTo(Point o) {
            if (this.likeCnt != o.likeCnt)
                return o.likeCnt - this.likeCnt;

            if (this.emptyCnt != o.emptyCnt)
                return o.emptyCnt - this.emptyCnt;

            if (this.x != o.x)
                return this.x - o.x;

            return this.y - o.y;
        }
    }
}
