/**
 * BOJ : 13164 G5 행복 유치원
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13164_행복유치원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        List<Integer> diff = new ArrayList<>();
        for (int i = 1; i < N; i++)
            diff.add(arr[i] - arr[i - 1]);

        Collections.sort(diff);

        int res = 0;
        for (int i = 0; i < N - K; i++)
            res += diff.get(i);

        System.out.println(res);
    }
}
