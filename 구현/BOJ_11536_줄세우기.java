/**
 * BOJ : 11536 S5 줄 세우기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11536_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] arr = new String[N];
        String[] sorted = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = sorted[i] = br.readLine();

        Arrays.sort(sorted);

        boolean inc = true;
        for (int i = 0; i < N; i++) {
            if (!arr[i].equals(sorted[i])) {
                inc = false;
                break;
            }
        }

        if (inc) {
            System.out.println("INCREASING");
        } else {
            boolean dec = true;
            for (int i = 0; i < N; i++) {
                if (!arr[i].equals(sorted[N - i - 1])) {
                    dec = false;
                    break;
                }
            }

            if (dec) {
                System.out.println("DECREASING");
            } else {
                System.out.println("NEITHER");
            }
        }
    }
}
