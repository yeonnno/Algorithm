/**
 * BOJ : 4889 S1 안정적인 문자열
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_04889_안정적인문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = 1;
        Stack<Character> stack;
        while (true) {
            char[] arr = br.readLine().toCharArray();

            if (arr[0] == '-') break;

            stack = new Stack<>();
            int res = 0, len = arr.length;
            for (int i = 0; i < len; i++) {
                if (arr[i] == '{') {
                    stack.push(arr[i]);
                } else {
                    if (stack.isEmpty()) {
                        res++;
                        stack.push('{');
                    } else {
                        stack.pop();
                    }
                }
            }

            res += stack.size() / 2;

            sb.append(tc++).append(". ").append(res).append("\n");
        }

        System.out.print(sb);
    }
}
