/**
 * BOJ : 1931 G5 회의실 배정
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_01931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            PQ.offer(new Room(start, end));
        }

        int res = 0, pre = 0;
        while (!PQ.isEmpty()) {
            Room now = PQ.poll();

            if (pre <= now.start) {
                pre = now.end;
                res++;
            }
        }

        System.out.println(res);
    }

    private static class Room implements Comparable<Room> {
        int start, end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (this.end == o.end)
                return this.start - o.start;
            return this.end - o.end;
        }
    }
}
