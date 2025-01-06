package 시뮬레이션;
/**
 * BOJ : 3190 G4 뱀
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_03190_뱀 {

    static int N, K, L, time;
    static boolean[][] map;
    static Map<Integer, String> info;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = true;
        }

        L = Integer.parseInt(br.readLine());

        info = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            info.put(x, dir);
        }

        time = 0;

        startGame();

        System.out.println(time);
    }

    private static void startGame() {
        Queue<Integer> snake = new LinkedList<>();
        snake.offer(1);

        int x = 1, y = 1, dir = 1;
        while (true) {
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            int next = ny * N + nx;

            if (!isPossible(nx, ny))
                break;

            if (snake.contains(next))
                break;

            snake.offer(next);

            if (map[nx][ny]) {
                map[nx][ny] = false;
            } else {
                snake.poll();
            }

            if (info.containsKey(time)) {
                int d = checkDir(info.get(time));
                dir = (4 + dir + d) % 4;
            }

            x = nx;
            y = ny;
        }
    }

    private static int checkDir(String s) {
        return s.equals("D") ? 1 : -1;
    }

    private static boolean isPossible(int nx, int ny) {
        return nx > 0 && nx <= N && ny > 0 && ny <= N;
    }
}
