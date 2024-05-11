/**
 * BOJ : 2234 G3 성곽
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_02234_성곽 {

    static int N, M, roomCnt, maxRoomSize, brokenMaxSize;
    static int[][] map, room;
    static HashMap<Integer, Integer> hashMap;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roomCnt = 0;
        maxRoomSize = 0;
        room = new int[N][M];
        hashMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] != 0) continue;

                roomCnt++;
                int roomSize = BFS(new Point(i, j), roomCnt);

                hashMap.put(roomCnt, roomSize);

                maxRoomSize = Math.max(maxRoomSize, roomSize);
            }
        }

        brokenMaxSize = 0;

        brokenWall();

        sb.append(roomCnt).append("\n").append(maxRoomSize).append("\n").append(brokenMaxSize);

        System.out.println(sb);
    }

    private static void brokenWall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int nowRoom = room[i][j];

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (!isPossible(nx, ny)) continue;
                    if (nowRoom == room[nx][ny]) continue;

                    brokenMaxSize = Math.max(brokenMaxSize, hashMap.get(nowRoom) + hashMap.get(room[nx][ny]));
                }
            }
        }
    }

    private static int BFS(Point p, int cnt) {
        Queue<Point> Q = new LinkedList<>();
        Q.offer(p);

        room[p.x][p.y] = cnt;

        int roomSize = 1;
        while (!Q.isEmpty()) {
            Point now = Q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dx[d];
                int ny = now.y + dy[d];

                if (!isPossible(nx, ny)) continue;
                if ((map[now.x][now.y] & (1 << d)) != 0 || room[nx][ny] != 0) continue;

                room[nx][ny] = room[now.x][now.y];
                Q.offer(new Point(nx, ny));
                roomSize++;
            }
        }

        return roomSize;
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
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
