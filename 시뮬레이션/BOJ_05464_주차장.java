/**
 * BOJ : 5464 S2 주차장
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_05464_주차장 {

    static int N, M, res;
    static int[] charge, weight, parking;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        charge = new int[N + 1];
        for (int i = 1; i <= N; i++)
            charge[i] = Integer.parseInt(br.readLine());

        weight = new int[M + 1];
        for (int i = 1; i <= M; i++)
            weight[i] = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> parkingSpace = new PriorityQueue<>();
        for (int i = 1; i <= N; i++)
            parkingSpace.offer(i);

        res = 0;
        parking = new int[M + 1];
        Queue<Integer> wait = new LinkedList<>();
        for (int i = 0; i < M * 2; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x > 0) {
                if (parkingSpace.isEmpty()) {
                    wait.offer(x);
                } else {
                    parking[x] = parkingSpace.poll();
                }
            } else {
                x = Math.abs(x);

                res += weight[x] * charge[parking[x]];

                if (wait.isEmpty()) {
                    parkingSpace.offer(parking[x]);
                } else {
                    parking[wait.poll()] = parking[x];
                }
            }
        }

        System.out.println(res);
    }
}
