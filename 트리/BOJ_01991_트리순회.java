/**
 * BOJ : 1991 S1 트리 순회
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01991_트리순회 {

    static int N;
    static Node[] tree;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) {
                tree[parent - 'A'] = new Node(parent);
            }

            if (left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[parent - 'A'].left = tree[left - 'A'];
            }

            if (right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[parent - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        sb.append("\n");

        inorder(tree[0]);
        sb.append("\n");

        postorder(tree[0]);
        sb.append("\n");

        System.out.print(sb);
    }

    private static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.val);
    }

    private static void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        sb.append(node.val);
        inorder(node.right);
    }

    private static void preorder(Node node) {
        if (node == null) return;

        sb.append(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    private static class Node {
        char val;
        Node left;
        Node right;

        public Node(char val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
