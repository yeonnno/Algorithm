/**
 * BOJ : 1713 S1 후보 추천하기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_01713_후보추천하기 {

    static int N, M;
    static Student[] students;
    static List<Student> photos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        students = new Student[101];
        photos = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (students[num] != null) {
                students[num].cnt++;
            } else {
                Collections.sort(photos);

                if (photos.size() == N) {
                    Student rm = photos.remove(N - 1);
                    students[rm.idx] = null;
                }

                students[num] = new Student(num, 1, i);
                photos.add(students[num]);
            }
        }

        Collections.sort(photos, (o1, o2) -> o1.idx - o2.idx);

        for (Student s : photos)
            sb.append(s.idx).append(" ");

        System.out.println(sb);
    }

    private static class Student implements Comparable<Student> {
        int idx;
        int cnt;
        int time;

        public Student(int idx, int cnt, int time) {
            this.idx = idx;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Student o) {
            if (o.cnt - cnt == 0) {
                return o.time - time;
            }
            return o.cnt - cnt;
        }
    }
}
