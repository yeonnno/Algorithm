/**
 * BOJ : 2331 S4 반복수열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_02331_반복수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        list.add(A);

        while (true) {
            int now = list.get(list.size() - 1);
            int num = 0;

            while (now != 0) {
                num += (int) Math.pow(now % 10, (double) P);
                now /= 10;
            }

            if (list.contains(num)) {
                System.out.println(list.indexOf(num));
                break;
            }

            list.add(num);
        }
    }
}
