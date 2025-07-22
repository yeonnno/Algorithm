/**
 * BOJ : 1337 S4 올바른 배열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ_01337_올바른배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);

        int res = 4;
        for (int num : list) {
            int cnt = 0;

            for (int i = 1; i < 5; i++) {
                if (!list.contains(num + i))
                    cnt++;
            }

            res = Math.min(res, cnt);
        }

        System.out.println(res);
    }
}
