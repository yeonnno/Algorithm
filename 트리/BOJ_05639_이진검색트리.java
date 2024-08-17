/**
 * BOJ : 5639 G4 이진 검색 트리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_05639_이진검색트리 {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String s = br.readLine();

            if (s == null || s.equals("")) break;

            root.insert(Integer.parseInt(s));
        }

        postorder(root);

        System.out.print(sb);
    }

    private static void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        sb.append(node.val).append("\n");
    }

    private static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public void insert(int v) {
            if (v < this.val) {
                if (this.left == null)
                    this.left = new Node(v);
                else
                    this.left.insert(v);
            } else {
                if (this.right == null)
                    this.right = new Node(v);
                else
                    this.right.insert(v);
            }
        }
    }
}
