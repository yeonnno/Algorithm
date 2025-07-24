/**
 * BOJ : 15312 S5 이름 궁합
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ_15312_이름궁합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] alpha = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

        String A = br.readLine();
        String B = br.readLine();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            list.add(alpha[A.charAt(i) - 'A']);
            list.add(alpha[B.charAt(i) - 'A']);
        }

        while (list.size() > 2) {
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < list.size() - 1; i++)
                tmp.add((list.get(i) + list.get(i + 1)) % 10);

            list = tmp;
        }

        sb.append(list.get(0)).append(list.get(1));
        System.out.println(sb);
    }
}
