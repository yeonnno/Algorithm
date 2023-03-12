package 백트래킹;
/**
 * BOJ : 14888 S1 연산자 끼워넣기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14888_연산자끼워넣기 {

    static int N, resMax, resMin;
    static int[] num, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        resMax = Integer.MIN_VALUE;
        resMin = Integer.MAX_VALUE;

        num = new int[N];
        operator = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, num[0]);

        sb.append(resMax).append("\n").append(resMin);
        System.out.println(sb);
    }

    private static void backtrack(int idx, int cal) {
        if (idx == N) {
            resMax = Math.max(resMax, cal);
            resMin = Math.min(resMin, cal);
        } else {
            for (int i = 0; i < 4; i++) {
                if (operator[i] > 0) {
                    operator[i]--;

                    switch (i) {
                        case 0:
                            backtrack(idx + 1, cal + num[idx]);
                            break;
                        case 1:
                            backtrack(idx + 1, cal - num[idx]);
                            break;
                        case 2:
                            backtrack(idx + 1, cal * num[idx]);
                            break;
                        case 3:
                            backtrack(idx + 1, cal / num[idx]);
                            break;
                    }

                    operator[i]++;
                }
            }
        }
    }
}
