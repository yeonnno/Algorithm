/**
 * BOJ : 1138 S2 한 줄로 서기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01138_한줄로서기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int[] res = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int x = 1;

            while (true) {
                if (arr[i] == 0 && res[x] == 0) {
                    res[x] = i;
                    break;
                } else if (res[x] == 0) {
                    arr[i]--;
                }

                x++;
            }
        }

        for (int i = 1; i <= N; i++)
            sb.append(res[i]).append(" ");

        System.out.println(sb);
    }
}
