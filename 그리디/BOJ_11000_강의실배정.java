/**
 * BOJ : 11000 G5 강의실 배정
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_11000_강의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Lecture(start, end));
        }

        Collections.sort(list);

        int time = 0;
        PriorityQueue<Integer> PQ = new PriorityQueue<>();
        for (Lecture now : list) {
            time = now.end;

            if (!PQ.isEmpty() && PQ.peek() <= now.start)
                PQ.poll();

            PQ.offer(time);
        }

        System.out.println(PQ.size());
    }

    private static class Lecture implements Comparable<Lecture> {
        int start;
        int end;

        public Lecture(int start, int end) {
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
