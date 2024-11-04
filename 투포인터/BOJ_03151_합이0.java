/**
 * BOJ : 3151 G4 합이 0
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_03151_합이0 {

    static int N;
    static long res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        res = 0l;
        for (int i = 0; i < N; i++) {
            if (arr[i] > 0) break;

            int start = i + 1, end = N - 1;
            while (start < end) {
                int s = 1, e = 1;
                int cur = arr[i] + arr[start] + arr[end];

                if (cur == 0) {
                    if (arr[start] == arr[end]) {
                        res += comb(end - start + 1);
                        break;
                    }

                    while (start + 1 < end && arr[start] == arr[start + 1]) {
                        s++;
                        start++;
                    }

                    while (start < end - 1 && arr[end] == arr[end - 1]) {
                        e++;
                        end--;
                    }

                    res += s * e;
                }

                if (cur < 0) start++;
                else end--;
            }
        }

        System.out.println(res);
    }

    private static long comb(int n) {
        return n * (n - 1) / 2;
    }
}
