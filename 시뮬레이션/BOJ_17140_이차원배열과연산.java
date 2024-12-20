/**
 * BOJ : 17140 G4 이차원 배열과 연산
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_17140_이차원배열과연산 {

    static int R, C, K, xLen, yLen, res;
    static int[][] A;
    static PriorityQueue<Pair> PQ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[101][101];
        for (int i = 1; i <= 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = -1;
        xLen = 3;
        yLen = 3;
        for (int i = 0; i <= 100; i++) {
            if (A[R][C] == K) {
                res = i;
                break;
            }

            if (xLen >= yLen) {
                for (int j = 1; j <= xLen; j++) {
                    rOper(j);
                }
            } else {
                for (int j = 1; j <= yLen; j++) {
                    cOper(j);
                }
            }
        }

        System.out.println(res);
    }

    private static void rOper(int x) {
        PQ = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= yLen; i++) {
            if (A[x][i] != 0)
                map.put(A[x][i], map.getOrDefault(A[x][i], 0) + 1);
        }

        if (map.isEmpty()) return;

        for (Integer key : map.keySet())
            PQ.offer(new Pair(key, map.get(key)));

        int idx = 1;
        while (!PQ.isEmpty()) {
            Pair now = PQ.poll();
            A[x][idx++] = now.num;
            A[x][idx++] = now.cnt;
        }

        yLen = Math.max(yLen, idx);

        for (int i = idx; i <= 100; i++)
            A[x][i] = 0;
    }

    private static void cOper(int x) {
        PQ = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= xLen; i++) {
            if (A[i][x] != 0)
                map.put(A[i][x], map.getOrDefault(A[i][x], 0) + 1);
        }

        if (map.isEmpty()) return;

        for (Integer key : map.keySet())
            PQ.offer(new Pair(key, map.get(key)));

        int idx = 1;
        while (!PQ.isEmpty()) {
            Pair now = PQ.poll();
            A[idx++][x] = now.num;
            A[idx++][x] = now.cnt;
        }

        xLen = Math.max(xLen, idx);

        for (int i = idx; i <= 100; i++)
            A[i][x] = 0;
    }

    private static class Pair implements Comparable<Pair> {
        int num;
        int cnt;

        public Pair(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.cnt == o.cnt)
                return this.num - o.num;
            else
                return this.cnt - o.cnt;
        }
    }
}
