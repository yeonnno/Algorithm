/**
 * BOJ : 9934 S1 완전 이진 트리
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_09934_완전이진트리 {

    static int K;
    static int[] building;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        tree = new ArrayList[K + 1];
        for (int i = 0; i <= K; i++)
            tree[i] = new ArrayList<>();

        int len = (int) Math.pow(2, K);

        building = new int[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < len; i++)
            building[i] = Integer.parseInt(st.nextToken());

        recur(1, 1, len);

        for (int i = 1; i <= K; i++) {
            for (int node : tree[i])
                sb.append(node).append(" ");
            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static void recur(int depth, int left, int right) {
        int mid = (left + right) / 2;

        tree[depth].add(building[mid]);

        if (depth == K) return;

        recur(depth + 1, left, mid - 1);
        recur(depth + 1, mid + 1, right);
    }
}
