/**
 * BOJ : 1374 G5 강의실
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_01374_강의실 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Lecture(num, start, end));
        }

        Collections.sort(list);

        int res = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            while (!PQ.isEmpty() && PQ.peek() <= list.get(i).start)
                PQ.poll();

            PQ.offer(list.get(i).end);
            res = Math.max(res, PQ.size());
        }

        System.out.println(res);
    }

    private static class Lecture implements Comparable<Lecture> {
        int num, start, end;

        public Lecture(int num, int start, int end) {
            this.num = num;
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture o) {
            if (this.start == o.start)
                return this.end - o.end;
            return this.start - o.start;
        }
    }
}
