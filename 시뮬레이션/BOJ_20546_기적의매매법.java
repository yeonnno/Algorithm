/**
 * BOJ : 20546 S5 기적의 매매법
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20546_기적의매매법 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[14];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 14; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int bnp = BNP();
        int timing = TIMING();

        if (bnp > timing)
            System.out.println("BNP");
        else if (bnp < timing)
            System.out.println("TIMING");
        else
            System.out.println("SAMESAME");
    }

    private static int BNP() {
        int cnt = 0, money = N;

        for (int i = 0; i < 14; i++) {
            int now = money / arr[i];

            cnt += now;
            money -= now * arr[i];
        }

        return money + cnt * arr[13];
    }

    private static int TIMING() {
        int cnt = 0, money = N;
        int up = 0, down = 0, pre = arr[0];

        for (int i = 1; i < 14; i++) {
            if (arr[i] > pre) {
                up++;
                down = 0;
            } else if (arr[i] < pre) {
                up = 0;
                down++;
            } else {
                up = 0;
                down = 0;
            }

            if (up == 3) {
                if (cnt != 0) money += arr[i] * cnt;

                up = 0;
                cnt = 0;
            } else if (down == 3) {
                int now = money / arr[i];

                cnt += now;
                money -= now * arr[i];
            }
        }

        return money + cnt * arr[13];
    }
}
