/**
 * BOJ : 10709 S5 기상캐스터
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10709_기상캐스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        for (int i = 0; i < H; i++) {
            String s = br.readLine();
            for (int j = 0; j < W; j++) {
                char ch = s.charAt(j);

                if (ch == 'c')
                    map[i][j] = 0;
                else
                    map[i][j] = -1;
            }
        }

        for (int i = 0; i < H; i++) {
            int num = 0;
            boolean check = false;

            for (int j = 0; j < W; j++) {
                if (map[i][j] == 0) {
                    num = 0;
                    check = true;
                } else if (check) {
                    num++;
                    map[i][j] = num;
                }

                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
