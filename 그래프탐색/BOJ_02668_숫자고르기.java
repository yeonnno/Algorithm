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
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        for (int i = 1; i <= N; i++)
            arr[i] = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            DFS(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (int x : list)
            sb.append(x).append("\n");

        System.out.print(sb);
    }

    private static void DFS(int now, int start) {
        if (arr[now] == start)
            list.add(start);

        if (!visited[arr[now]]) {
            visited[arr[now]] = true;
            DFS(arr[now], start);
            visited[arr[now]] = false;
        }
    }
}
