/**
 * 미해결
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_22944_죽음의비 {

    static int N, H, D, startX, startY, endX, endY;
    static char[][] map;
    static Point[][] moveMap;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken()); // 체력
        D = Integer.parseInt(st.nextToken()); // 우산 내구도

        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'S') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 'E') {
                    endX = i;
                    endY = j;
                }
            }
        }

        moveMap = new Point[N][N];
        visited = new boolean[N][N];
        BFS(new Point(startX, startY, H, D, 0));

        if (moveMap[endX][endY] != null) {
            System.out.println(moveMap[endX][endY].moveCnt);
        } else {
            System.out.println(-1);
        }
    }

    private static void BFS(Point p) {
        Queue<Point> Q = new LinkedList<>();
        visited[p.x][p.y] = true;
        moveMap[p.x][p.y] = p;
        Q.add(p);

        while (!Q.isEmpty()) {
            int size = Q.size();

            for (int i = 0; i < size; i++) {
                Point now = Q.poll();
                int x = now.x;
                int y = now.y;
                int h = now.h;
                int d = now.d;
                int moveCnt = now.moveCnt;

                for (int dir = 0; dir < 4; dir++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    int nd = d;
                    int nh = h;
                    int nMoveCnt = moveCnt + 1;

                    if (!isPossible(nx, ny) || visited[nx][ny]) continue;

                    if (map[nx][ny] == 'E') {
                        if (moveMap[nx][ny] != null) {
                            if (moveMap[nx][ny].moveCnt > nMoveCnt) {
                                moveMap[nx][ny] = new Point(nx, ny, h, d, nMoveCnt);
                            }
                        } else {
                            moveMap[nx][ny] = new Point(nx, ny, h, d, nMoveCnt);
                        }
                    } else if (map[nx][ny] == '.') {
                        if (d > 0) { // 우산 쓰고있는 경우
                            nd -= 1; // 우산 내구도 감소
                        } else { // 우산 쓰고있지 않은 경우
                            nh -= 1; // 체력 감소
                        }

                        if (nh > 0) { // 체력이 0보다 클 경우
                            if (moveMap[nx][ny] != null) {
                                if (moveMap[nx][ny].moveCnt > nMoveCnt) {
                                    moveMap[nx][ny] = new Point(nx, ny, nd, nh, nMoveCnt);
                                    Q.add(new Point(nx, ny, nd, nh, nMoveCnt));
                                }
                            } else {
                                moveMap[nx][ny] = new Point(nx, ny, nd, nh, nMoveCnt);
                                Q.add(new Point(nx, ny, nd, nh, nMoveCnt));
                            }
                        }
                    } else if (map[nx][ny] == 'U') {
//                        nh -= 1;
                        nd = D-1;

                        if (moveMap[nx][ny] != null) {
                            if (moveMap[nx][ny].moveCnt > nMoveCnt) {
                                moveMap[nx][ny] = new Point(nx, ny, nd, nh, nMoveCnt);
                                Q.add(new Point(nx, ny, nd, nh, nMoveCnt));
                            }
                        } else {
                            moveMap[nx][ny] = new Point(nx, ny, nd, nh, nMoveCnt);
                            Q.add(new Point(nx, ny, nd, nh, nMoveCnt));
                        }
                    }

                }
                visited[x][y] = true;
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
        int moveCnt;

        Point(int x, int y, int h, int d, int moveCnt) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
            this.moveCnt = moveCnt;
        }
    }
}
