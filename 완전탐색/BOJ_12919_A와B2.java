/**
 * BOJ : 12919 G5 A와 B 2
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12919_A와B2 {

    static String S, T;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        flag = false;

        DFS(S, T);

        if (flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void DFS(String s, String t) {
        if (flag) return;

        if (s.length() == t.length()) {
            if (s.equals(t)) flag = true;
            return;
        }

        if (t.charAt(0) == 'B') {
            String sub = t.substring(1);
            StringBuilder sb = new StringBuilder(sub);
            String st = sb.reverse().toString();
            DFS(s, st);
        }

        if (t.charAt(t.length() - 1) == 'A') {
            t = t.substring(0, t.length() - 1);
            DFS(s, t);
        }
    }
}
