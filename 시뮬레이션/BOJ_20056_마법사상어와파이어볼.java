/**
 * BOJ : 20056 G4 마법사 상어와 파이어볼
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_20056_마법사상어와파이어볼 {

    static int N, M, K, res;
    static ArrayList<Fireball>[][] map;
    static ArrayList<Fireball> fireballs;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        fireballs = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 행
            int y = Integer.parseInt(st.nextToken()); // 열
            int m = Integer.parseInt(st.nextToken()); // 질량
            int s = Integer.parseInt(st.nextToken()); // 속력
            int d = Integer.parseInt(st.nextToken()); // 방향

            fireballs.add(new Fireball(x, y, m, s, d));
        }

        for (int i = 0; i < K; i++) {
            moveFireball();
            divideFireball();
        }

        res = 0;
        for (Fireball fireball : fireballs)
            res += fireball.m;

        System.out.println(res);
    }

    private static void divideFireball() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int size = map[x][y].size();

                if (size < 2) {
                    map[x][y].clear();
                    continue;
                }

                int mSum = 0, sSum = 0, evenCnt = 0, oddCnt = 0;
                for (Fireball now : map[x][y]) {
                    mSum += now.m;
                    sSum += now.s;

                    if (now.d % 2 == 0)
                        evenCnt++;
                    else
                        oddCnt++;

                    fireballs.remove(now);
                }

                map[x][y].clear();

                mSum /= 5;
                if (mSum == 0) continue;

                sSum /= size;

                if (evenCnt == size || oddCnt == size) {
                    for (int i = 0; i < 8; i += 2) {
                        fireballs.add(new Fireball(x, y, mSum, sSum, i));
                    }
                } else {
                    for (int i = 1; i < 8; i += 2) {
                        fireballs.add(new Fireball(x, y, mSum, sSum, i));
                    }
                }
            }
        }
    }

    private static void moveFireball() {
        for (Fireball now : fireballs) {
            now.x = (N + now.x + dx[now.d] * (now.s % N)) % N;
            now.y = (N + now.y + dy[now.d] * (now.s % N)) % N;

            map[now.x][now.y].add(now);
        }
    }

    private static class Fireball {
        int x, y, m, s, d;

        public Fireball(int x, int y, int m, int s, int d) {
            this.x = x;
            this.y = y;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }
}
