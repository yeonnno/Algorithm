/**
 * BOJ : 2250 G2 트리의 높이와 너비
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_02250_트리의높이와너비 {

    static int N, root, idx, totalLevel, level, width;
    static int[] minLevel, maxLevel;
    static Node[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        tree = new Node[N + 1];
        minLevel = new int[N + 1];
        maxLevel = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new Node(-1, -1);
            minLevel[i] = N;
            maxLevel[i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            tree[val].left = left;
            tree[val].right = right;

            if (left != -1) tree[left].parent = val;
            if (right != -1) tree[right].parent = val;
        }

        root = 0;
        for (int i = 1; i <= N; i++) {
            if (tree[i].parent == -1) {
                root = i;
                break;
            }
        }

        idx = 1;
        totalLevel = 0;

        inorder(tree[root], 1);

        level = 1;
        width = maxLevel[1] - minLevel[1] + 1;
        for (int i = 2; i <= totalLevel; i++) {
            int w = maxLevel[i] - minLevel[i] + 1;

            if (width < w) {
                width = w;
                level = i;
            }
        }

        System.out.println(level + " " + width);
    }

    private static void inorder(Node node, int lv) {
        if (totalLevel < lv)
            totalLevel = lv;

        if (node.left != -1)
            inorder(tree[node.left], lv + 1);

        minLevel[lv] = Math.min(minLevel[lv], idx);
        maxLevel[lv] = idx;
        idx++;

        if (node.right != -1)
            inorder(tree[node.right], lv + 1);
    }

    private static class Node {
        int parent;
        int left;
        int right;

        public Node(int left, int right) {
            this.parent = -1;
            this.left = left;
            this.right = right;
        }
    }
}
