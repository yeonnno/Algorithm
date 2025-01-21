/**
 * BOJ : 2504 G5 괄호의 값
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_02504_괄호의값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int res = 0, val = 1, len = s.length();
        boolean check = true;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
                val *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                val *= 3;
            } else if (ch == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    check = false;
                    break;
                } else if (s.charAt(i - 1) == '(') {
                    res += val;
                }

                stack.pop();
                val /= 2;
            } else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    check = false;
                    break;
                } else if (s.charAt(i - 1) == '[') {
                    res += val;
                }

                stack.pop();
                val /= 3;
            }
        }

        if (!stack.isEmpty() || !check) System.out.println(0);
        else System.out.println(res);
    }
}
