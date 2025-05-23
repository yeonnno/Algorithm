/**
 * BOJ : 1092 G5 배
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        List<Integer> crane = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            crane.add(Integer.parseInt(st.nextToken()));

        crane.sort(Collections.reverseOrder());

        int M = Integer.parseInt(br.readLine());

        List<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            box.add(Integer.parseInt(st.nextToken()));

        box.sort(Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
        } else {
            int res = 0;

            while (!box.isEmpty()) {
                int craneIdx = 0, boxIdx = 0;

                while (craneIdx < N) {
                    if (boxIdx == box.size())
                        break;

                    if (box.get(boxIdx) <= crane.get(craneIdx)) {
                        box.remove(boxIdx);
                        craneIdx++;
                    } else {
                        boxIdx++;
                    }
                }

                res++;
            }

            System.out.println(res);
        }
    }
}
