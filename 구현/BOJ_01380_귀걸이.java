/**
 * BOJ : 1380 S5 귀걸이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_01380_귀걸이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0)
                break;

            String[] girls = new String[N];
            for (int i = 0; i < N; i++)
                girls[i] = br.readLine();

            ArrayList<Integer> earringList = new ArrayList<>();
            for (int i = 0; i < N * 2 - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());

                if (earringList.contains(num))
                    earringList.remove(Integer.valueOf(num));
                else
                    earringList.add(num);
            }

            int idx = earringList.get(0);
            sb.append(tc++).append(" ").append(girls[idx - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
