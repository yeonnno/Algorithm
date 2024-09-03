/**
 * BOJ : 2263 G1 트리의 순회
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02263_트리의순회 {

    static int N;
    static int[] inorder, inorderIdx, postorder;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        inorder = new int[N];
        inorderIdx = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIdx[inorder[i]] = i;
        }

        postorder = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            postorder[i] = Integer.parseInt(st.nextToken());

        preorder(0, N - 1, 0, N - 1);

        System.out.println(sb);
    }

    private static void preorder(int inS, int inE, int postS, int postE) {
        if (inS > inE || postS > postE)
            return;

        int root = postorder[postE];
        int rootIdx = inorderIdx[root];


        sb.append(root).append(" ");
        preorder(inS, rootIdx - 1, postS, postS + (rootIdx - inS) - 1);
        preorder(rootIdx + 1, inE, postS + (rootIdx - inS), postE - 1);
    }
}
