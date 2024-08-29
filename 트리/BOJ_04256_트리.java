/**
 * BOJ : 4256 G2 트리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_04256_트리 {

    static int N;
    static int[] preorder, inorder;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            preorder = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                preorder[i] = Integer.parseInt(st.nextToken());

            inorder = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++)
                inorder[i] = Integer.parseInt(st.nextToken());

            postorder(0, 0, N);

            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void postorder(int rootIdx, int start, int end) {
        int root = preorder[rootIdx];

        for (int i = start; i < end; i++) {
            if (root == inorder[i]) {
                postorder(rootIdx + 1, start, i);
                postorder(rootIdx + (i - start + 1), i + 1, end);
                sb.append(root).append(" ");
                return;
            }
        }
    }
}
