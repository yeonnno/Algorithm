/**
 * BOJ : 2980 S4 도로와 신호등
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02980_도로와신호등 {

    static int N, L, D, R, G, pos, time;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        pos = 0;
        time = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            D = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());

            time += D - pos;
            pos = D;

            int gap = time % (R + G);
            if (gap < R)
                time += R - gap;
        }

        time += L - pos;

        System.out.println(time);
    }
}
