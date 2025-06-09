/**
 * BOJ : 11509 G5 풍선 맞추기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11509_풍선맞추기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int res = 0;
        int[] arrow = new int[1000001];
        for (int i = 0; i < N; i++) {
            if (arrow[arr[i]] > 0) {
                arrow[arr[i]]--;
                arrow[arr[i] - 1]++;
            } else {
                res++;
                arrow[arr[i] - 1]++;
            }
        }

        System.out.println(res);
    }
}
