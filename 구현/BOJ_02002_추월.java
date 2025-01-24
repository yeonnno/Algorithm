/**
 * BOJ : 2002 S1 추월
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_02002_추월 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Queue<String> in = new LinkedList<>();
        for (int i = 0; i < N; i++)
            in.offer(br.readLine());

        Queue<String> out = new LinkedList<>();
        for (int i = 0; i < N; i++)
            out.offer(br.readLine());

        int res = 0;
        while (!out.isEmpty()) {
            String outCar = out.poll();

            if (!in.peek().equals(outCar)) {
                res++;
                in.remove(outCar);
            } else {
                in.poll();
            }
        }

        System.out.println(res);
    }
}

