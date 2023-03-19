/**
 * BOJ : 2529 S1 부등호
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_02529_부등호 {

    static int K;
    static char[] arr;
    static boolean[] visited;
    static ArrayList<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        K = Integer.parseInt(br.readLine());

        arr = new char[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        visited = new boolean[10];
        list = new ArrayList<>();

        backtrack(0, "");

        sb.append(list.get(list.size() - 1)).append("\n").append(list.get(0));

        System.out.println(sb);
    }

    private static void backtrack(int depth, String num) {
        if (depth == K + 1) {
            list.add(num);
        } else {
            for (int i = 0; i < 10; i++) {
                if (visited[i]) continue;

                if (depth == 0 || compare(num.charAt(depth - 1) - '0', i, arr[depth - 1])) {
                    visited[i] = true;
                    backtrack(depth + 1, num + i);
                    visited[i] = false;
                }
            }
        }
    }

    private static boolean compare(int a, int b, char c) {
        if (c == '<') {
            if (a < b) return true;
        } else if (c == '>') {
            if (a > b) return true;
        }
        return false;
    }
}
