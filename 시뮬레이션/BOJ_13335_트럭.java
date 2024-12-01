/**
 * BOJ : 13335 S1 트럭
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {

    static int N, W, L;
    static Queue<Integer> truck, bridge;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        truck = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            truck.offer(Integer.parseInt(st.nextToken()));

        bridge = new LinkedList<>();
        for (int i = 0; i < W; i++)
            bridge.offer(0);

        int time = 0, bridgeWeight = 0;
        while (!bridge.isEmpty()) {
            time++;
            bridgeWeight -= bridge.poll();

            if (!truck.isEmpty()) {
                if (truck.peek() + bridgeWeight <= L) {
                    bridgeWeight += truck.peek();
                    bridge.offer(truck.poll());
                } else {
                    bridge.offer(0);
                }
            }
        }

        System.out.println(time);
    }
}
