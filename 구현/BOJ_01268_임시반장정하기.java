/**
 * BOJ : 1268 S5 임시 반장 정하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_01268_임시반장정하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[][] students = new int[N + 1][5];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                students[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int res = 1, max = 0;
        Set<Integer> sameClass;
        for (int i = 1; i <= N; i++) {
            sameClass = new HashSet<>();

            for (int j = 0; j < 5; j++) {
                for (int k = 1; k <= N; k++) {
                    if (students[i][j] == students[k][j] && k != i) {
                        sameClass.add(k);
                    }
                }
            }

            int size = sameClass.size();
            if (max < size) {
                max = size;
                res = i;
            }
        }

        System.out.println(res);
    }
}
