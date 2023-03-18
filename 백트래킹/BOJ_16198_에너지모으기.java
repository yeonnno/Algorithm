/**
 * BOJ : 16198 S1 에너지 모으기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_16198_에너지모으기 {

    static int N, res;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        res = Integer.MIN_VALUE;
        backtrack(0);

        System.out.println(res);
    }

    private static void backtrack(int sum) {
        if (list.size() <= 2) {
            res = Math.max(res, sum);
        } else {
            for (int i = 1; i < list.size() - 1; i++) {
                int temp = list.get(i);
                int energy = list.get(i - 1) * list.get(i + 1);
                list.remove(i);
                backtrack(sum + energy);
                list.add(i, temp);
            }
        }
    }
}
