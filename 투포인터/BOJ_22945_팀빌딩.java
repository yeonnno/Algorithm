/**
 * BOJ : 22945 G4 팀 빌딩
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22945_팀빌딩 {

    static int N, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        res = 0;
        int start = 0, end = N - 1;
        while (start <= end) {
            int min = Math.min(arr[start], arr[end]);
            res = Math.max(res, min * (end - start - 1));

            if (arr[start] < arr[end])
                start++;
            else
                end--;
        }

        System.out.println(res);
    }
}
