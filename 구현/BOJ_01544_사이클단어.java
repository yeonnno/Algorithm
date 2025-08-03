/**
 * BOJ : 1544 S4 사이클 단어
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_01544_사이클단어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int res = 0;
        ArrayList<String>[] list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();

            String s = br.readLine();
            for (int j = 0; j < s.length(); j++)
                list[i].add(s.substring(j) + s.substring(0, j));

            boolean check = true;
            for (int j = 0; check && j <= i - 1; j++) {
                for (int k = 0; check && k < list[j].size(); k++) {
                        if (s.equals(list[j].get(k)))
                            check = false;
                }
            }

            if (check)
                res++;
        }

        System.out.println(res);
    }
}
