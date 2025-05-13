/**
 * BOJ : 1105 S1 팔
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_01105_팔 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        String L = st.nextToken();
        String R = st.nextToken();

        int lLen = L.length(), rLen = R.length();

        if (lLen != rLen) {
            System.out.println(0);
        } else {
            int idx = 0, res = 0;

            while (idx < lLen && L.charAt(idx) == R.charAt(idx)) {
                if (L.charAt(idx) == '8')
                    res++;

                idx++;
            }

            System.out.println(res);
        }
    }
}
