/**
 * BOJ : 12933 S2 오리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12933_오리 {

    static final char[] quack = {'q', 'u', 'a', 'c', 'k'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int len = arr.length;
        if (len % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int res = 0;
        while (len != 0) {
            int idx = 0, now = 0;
            boolean check = false;
            int[] tmp = new int[5];

            while (idx < arr.length) {
                if (arr[idx] == quack[now]) {
                    tmp[now++] = idx;

                    if (now == 5) {
                        check = true;
                        len -= 5;
                        now = 0;

                        for (int i = 0; i < 5; i++)
                            arr[tmp[i]] = 'X';
                    }
                }

                idx++;
            }

            if (check) res++;
            else break;
        }

        System.out.println(len == 0 ? res : -1);
    }
}
