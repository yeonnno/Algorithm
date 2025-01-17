/**
 * BOJ : 1138 S2 한 줄로 서기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01138_한줄로서기 {

    static int N;
    static int[] arr, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        res = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            int j = 1;

            while (true) {
                if (arr[i] == 0 && res[j] == 0) {
                    res[j] = i;
                    break;
                } else if (res[j] == 0) {
                    arr[i]--;
                }

                j++;
            }
        }

        for (int i = 1; i <= N; i++)
            System.out.print(res[i] + " ");
    }
}
