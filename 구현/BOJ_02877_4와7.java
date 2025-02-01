/**
 * BOJ : 2877 G5 4와 7
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_02877_4와7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        String s = Integer.toBinaryString(K + 1).replace('0', '4').replace('1', '7');
        for (int i = 1; i < s.length(); i++)
            sb.append(s.charAt(i));

        System.out.println(sb);
    }
}
