/**
 * BOJ : 20436 S4 ZOAC 3
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20436_ZOAC3 {

    static int res;
    static char SL, SR;
    static Map<Character, int[]> leftKey, rightKey;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        leftKey = new HashMap<>();
        rightKey = new HashMap<>();
        setKey();

        st = new StringTokenizer(br.readLine());
        SL = st.nextToken().charAt(0);
        SR = st.nextToken().charAt(0);

        res = 0;
        String s = br.readLine();
        for (int i = 0; i < s.length(); i++) {
            char alpha = s.charAt(i);

            if (leftKey.containsKey(alpha)) {
                res += getDist(leftKey.get(SL), leftKey.get(alpha));
                SL = alpha;
            } else {
                res += getDist(rightKey.get(SR), rightKey.get(alpha));
                SR = alpha;
            }
        }

        System.out.println(res);
    }

    private static int getDist(int[] arrA, int[] arrB) {
        return Math.abs(arrA[0] - arrB[0]) + Math.abs(arrA[1] - arrB[1]) + 1;
    }

    private static void setKey() {
        leftKey.put('q', new int[]{0, 0});
        leftKey.put('w', new int[]{0, 1});
        leftKey.put('e', new int[]{0, 2});
        leftKey.put('r', new int[]{0, 3});
        leftKey.put('t', new int[]{0, 4});
        leftKey.put('a', new int[]{1, 0});
        leftKey.put('s', new int[]{1, 1});
        leftKey.put('d', new int[]{1, 2});
        leftKey.put('f', new int[]{1, 3});
        leftKey.put('g', new int[]{1, 4});
        leftKey.put('z', new int[]{2, 0});
        leftKey.put('x', new int[]{2, 1});
        leftKey.put('c', new int[]{2, 2});
        leftKey.put('v', new int[]{2, 3});

        rightKey.put('y', new int[]{0, 5});
        rightKey.put('u', new int[]{0, 6});
        rightKey.put('i', new int[]{0, 7});
        rightKey.put('o', new int[]{0, 8});
        rightKey.put('p', new int[]{0, 9});
        rightKey.put('h', new int[]{1, 5});
        rightKey.put('j', new int[]{1, 6});
        rightKey.put('k', new int[]{1, 7});
        rightKey.put('l', new int[]{1, 8});
        rightKey.put('b', new int[]{2, 4});
        rightKey.put('n', new int[]{2, 5});
        rightKey.put('m', new int[]{2, 6});
    }
}
