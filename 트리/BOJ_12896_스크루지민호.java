/**
 * BOJ : 12896 G2 스크루지 민호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_12896_스크루지민호 {

    static int N, start, res;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            tree[x].add(y);
            tree[y].add(x);
        }
        
        start = 1;
        
        res = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        visited[start] = true;
        DFS(start, 0);

        res = Integer.MIN_VALUE;
        visited = new boolean[N + 1];
        visited[start] = true;
        DFS(start, 0);

        System.out.println((res + 1) / 2);
    }

    private static void DFS(int now, int sum) {
        if (res < sum) {
            res = sum;
            start = now;
        }

        for (int next : tree[now]) {
            if (visited[next]) continue;

            visited[next] = true;
            DFS(next, sum + 1);
        }
    }
}
