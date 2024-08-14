/**
 * BOJ : 1068 G5 트리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_01068_트리 {

    static int N, root, deleteNode, res;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N];
        for (int i = 0; i < N; i++)
            tree[i] = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());

            if (node == -1) {
                root = i;
                continue;
            }

            tree[node].add(i);
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (root == deleteNode) {
            System.out.println(0);
        } else {
            res = 0;
            
            nodeDelete(root);
            countLeaf(root);

            System.out.println(res);
        }
    }

    private static void countLeaf(int root) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(root);

        while (!Q.isEmpty()) {
            int now = Q.poll();
            int size = tree[now].size();

            if (size == 0) {
                res++;
            } else {
                for (int next : tree[now])
                    Q.offer(next);
            }
        }
    }

    private static void nodeDelete(int node) {
        for (int child : tree[node]) {
            if (child == deleteNode) {
                tree[node].remove(Integer.valueOf(child));
                return;
            }

            nodeDelete(child);
        }
    }
}
