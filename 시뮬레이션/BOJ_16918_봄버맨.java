/**
 * BOJ : 16918 S1 봄버맨
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16918_봄버맨 {

    static int N, M, C;
    static char[][] map;
    static int[][] bombTime;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        bombTime = new int[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);

                if (map[i][j] == 'O')
                    bombTime[i][j] = 3;
            }
        }

        int time = 0;
        while (time++ < C) {
            if (time % 2 == 0) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (map[i][j] != '.') continue;

                        map[i][j] = 'O';
                        bombTime[i][j] = time + 3;
                    }
                }
            } else {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (bombTime[i][j] != time) continue;

                        map[i][j] = '.';

                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (!isPossible(nx, ny)) continue;

                            if (map[nx][ny] == 'O' && bombTime[nx][ny] != time) {
                                map[nx][ny] = '.';
                                bombTime[nx][ny] = 0;
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
}
