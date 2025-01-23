/**
 * BOJ : 2304 S2 창고 다각형
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_02304_창고다각형 {

    static int N, res;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        arr = new int[1001];

        int start = 1001, end = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            arr[L] = H;
            start = Math.min(start, L);
            end = Math.max(end, L);
        }

        Stack<Integer> stack = new Stack<>();

        int num = arr[start];
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] < num) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = num;
                }

                num = arr[i];
            }
        }

        stack.clear();

        num = arr[end];
        for (int i = end - 1; i >= start; i--) {
            if (arr[i] < num) {
                stack.push(i);
            } else {
                while (!stack.isEmpty()) {
                    int x = stack.pop();
                    arr[x] = num;
                }

                num = arr[i];
            }
        }

        res = 0;
        for (int i = start; i <= end; i++)
            res += arr[i];

        System.out.println(res);
    }
}
