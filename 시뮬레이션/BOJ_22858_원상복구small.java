/**
 * BOJ : 22858 S3 원상 복구 small
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_22858_원상복구small {

    static int N, K;
    static int[] card, order, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        card = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            card[i] = Integer.parseInt(st.nextToken());

        order = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            order[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i < K; i++) {
            tmp = new int[N + 1];

            for (int j = 1; j <= N; j++)
                tmp[order[j]] = card[j];

            card = tmp.clone();
        }

        for (int i = 1; i <= N; i++)
            sb.append(card[i]).append(" ");

        System.out.println(sb);
    }
}
