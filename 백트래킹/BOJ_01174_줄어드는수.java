/**
 * BOJ : 1174 G5 줄어드는 수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_01174_줄어드는수 {

    static int N;
    static int[] number = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        backtrack(0, 0);

        Collections.sort(list);

        try {
            System.out.println(list.get(N-1));
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
