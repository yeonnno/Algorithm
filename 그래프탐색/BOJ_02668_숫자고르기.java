/**
 * BOJ : 2668 G5 숫자고르기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_02668_숫자고르기 {

    static int N;
    static int[] num;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        num = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    private static void DFS(int n, int start) {
        if (num[n] == start)
            list.add(start);

        if (!visited[num[n]]) {
            visited[num[n]] = true;
            DFS(num[n], start);
            visited[num[n]] = false;
        }
    }
}
