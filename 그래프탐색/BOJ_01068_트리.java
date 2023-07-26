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

    static int N, root, delete, res;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int v = Integer.parseInt(st.nextToken());
            if (v == -1) {
                root = i;
                continue;
            }

            adj[v].add(i);
        }

        delete = Integer.parseInt(br.readLine());
        res = 0;

        if (delete == root) {
            System.out.println(0);
        } else {
            deleteNode(root);
            countLeaf(root);
            System.out.println(res);
        }
    }

    private static void countLeaf(int root) {
        Queue<Integer> Q = new LinkedList<>();
        Q.add(root);

        while (!Q.isEmpty()) {
            int now = Q.poll();
            int size = adj[now].size();

            if (size == 0) {
                res++;
            } else {
                for (int i = 0; i < size; i++) {
                    Q.add(adj[now].get(i));
                }
            }
        }
    }

    private static void deleteNode(int node) {
        int size = adj[node].size();
        for (int i = 0; i < size; i++) {
            int child = adj[node].get(i);

            if (child == delete) {
                adj[node].remove(i);
                return;
            }

            deleteNode(child);
        }
    }

}
