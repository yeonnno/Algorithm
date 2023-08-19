/**
 * BOJ : 1038 G5 감소하는 수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_01038_감소하는수 {

    static int N;
    static ArrayList<Long> list;
    static int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        backtrack(0, 0L);

        Collections.sort(list);

        try {
            System.out.println(list.get(N));
        } catch (Exception e) {
            System.out.println(-1);
        }
    }

    private static void backtrack(int depth, long num) {
        if (!list.contains(num)) {
            list.add(num);
        }

        if (depth > 9) return;

        backtrack(depth + 1, (num * 10) + number[depth]);
        backtrack(depth + 1, num);
    }
}
