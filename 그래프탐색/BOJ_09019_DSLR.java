/**
 * BOJ : 9019 S4 DSLR
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_09019_DSLR {

    static int A, B;
    static boolean[] visited;
    static String[] command;
    static StringBuilder sb, tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            visited = new boolean[10000];
            command = new String[10000];
            Arrays.fill(command, "");

            BFS();

            sb.append(command[B]).append("\n");
        }

        System.out.print(sb);
    }

    private static void BFS() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(A);

        visited[A] = true;

        while (!Q.isEmpty()) {
            int now = Q.poll();

            if (now == B) return;

            for (int d = 0; d < 4; d++) {
                int next = getNext(d, now);

                if (visited[next]) continue;

                visited[next] = true;

                tmp = new StringBuilder();
                command[next] = tmp.append(command[now]).append(getCommand(d)).toString();
                Q.offer(next);
            }
        }
    }

    private static String getCommand(int x) {
        switch (x) {
            case 0:
                return "D";
            case 1:
                return "S";
            case 2:
                return "L";
            case 3:
                return "R";
        }

        return null;
    }

    private static int getNext(int x, int now) {
        switch (x) {
            case 0:
                return now * 2 % 10000;
            case 1:
                return now == 0 ? 9999 : now - 1;
            case 2:
                return (now % 1000 * 10) + (now / 1000);
            case 3:
                return (now % 10 * 1000) + (now / 10);
        }

        return -1;
    }
}
