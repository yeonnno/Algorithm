/**
 * BOJ : 1235 S4 학생 번호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BOJ_01235_학생번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] num = new String[N];
        for (int i = 0; i < N; i++)
            num[i] = br.readLine();

        int res = 0, len = num[0].length();
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= len; i++) {

            for (int j = 0; j < N; j++)
                set.add(num[j].substring(len - i));

            if (set.size() == N) {
                res = i;
                break;
            }

            set.clear();
        }

        System.out.println(res);
    }
}
