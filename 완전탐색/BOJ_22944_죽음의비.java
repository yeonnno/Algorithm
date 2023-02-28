/**
 * BOJ : 22944 G4 죽음의 비
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22944_죽음의비 {

    static int N, H, D, startX, startY, res;
    static char[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        visited = new int[N][N];
        res = -1;
        BFS(new Point(startX, startY, H, 0));

        System.out.println(res);
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        visited[p.x][p.y] = p.h;
        Q.add(p);
        int min = 0;

        while (!Q.isEmpty()) {
            int size = Q.size();
            min++;

            for (int si = 0; si < size; si++) {
                Point now = Q.poll();
                int x = now.x;
                int y = now.y;
                int h = now.h;
                int d = now.d;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    int nh = h;
                    int nd = d;

                    if (!isPossible(nx, ny)) continue;

                    if (map[nx][ny] == 'E') { // 도착지점 도달했을 때
                        res = min;
                        return;
                    }

                    if (map[nx][ny] == 'U') { // 우산을 만났을 때
                        nd = D;
                    }

                    if (nd > 0) nd--; // 우산 내구도가 남아있을 때 내구도 감소
                    else nh--; // 우산 내구도 남아있지 않을 때 체력 감소

                    if (nh == 0) continue; // 체력이 0일때

                    if (visited[nx][ny] < nh + nd) { // 체력 + 내구도가 더 많이 남아있을 경우
                        visited[nx][ny] = nh + nd;   // 더 먼 거리를 이동할 수 있으므로 갱신해줌
                        Q.add(new Point(nx, ny, nh, nd));
                    }
                }
            }

        }
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
            return true;
        }
        return false;
    }

    static class Point {
        int x;
        int y;
        int h;
        int d;

        Point(int x, int y, int h, int d) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
        }
    }
}
