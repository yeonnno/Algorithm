/**
 * BOJ : 1439 S5 뒤집기
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01439_뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        StringTokenizer zero = new StringTokenizer(s, "0");
        StringTokenizer one = new StringTokenizer(s, "1");

        System.out.println(Math.min(zero.countTokens(), one.countTokens()));
    }
}
