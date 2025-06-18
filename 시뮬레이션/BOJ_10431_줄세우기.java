/**
 * BOJ : 10431 S5 줄세우기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int P = Integer.parseInt(br.readLine());
        for (int p = 0; p < P; p++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());

            int[] arr = new int[20];
            for (int i = 0; i < 20; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            int res = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] < arr[j]) res++;
                }
            }

            sb.append(T).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
