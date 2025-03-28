/**
 * BOJ : 19598 G5 최소 회의실 개수
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_19598_최소회의실개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        List<Room> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Room(start, end));
        }

        Collections.sort(list);

        int res = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            while (!PQ.isEmpty() && PQ.peek() <= list.get(i).start) {
                PQ.poll();
            }

            PQ.offer(list.get(i).end);
            res = Math.max(res, PQ.size());
        }

        System.out.println(res);
    }

    private static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            if (this.start == o.start)
                return this.end - o.end;

            return this.start - o.start;
        }
    }
}
