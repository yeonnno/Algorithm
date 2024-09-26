/**
 * BOJ : 1484 G5 다이어트
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_01484_다이어트 {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        boolean check = false;
        long start = 1, end = 2;
        while (end < 100000) {
            long diff = (end * end) - (start * start);

            if (diff == N) {
                sb.append(end).append("\n");
                check = true;
            }

            if (diff > N) start++;
            else end++;
        }

        if (check)
            System.out.print(sb);
        else
            System.out.println(-1);
    }
}
