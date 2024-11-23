/**
 * BOJ : 17952 S3 과제는 끝나지 않아
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17952_과제는끝나지않아 {

    static int N, res;
    static Stack<Task> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        stack = new Stack<>();

        res = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            if (x == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken()) - 1;

                if (time == 0)
                    res += score;
                else
                    stack.push(new Task(score, time));
            } else if (x == 0 && !stack.isEmpty()) {
                Task task = stack.pop();
                task.time--;

                if (task.time == 0)
                    res += task.score;
                else
                    stack.push(task);
            }
        }

        System.out.println(res);
    }

    private static class Task {
        int score;
        int time;

        public Task(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
