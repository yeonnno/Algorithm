import java.util.*;

class Solution {
    
    static int len;
    static boolean[] check;
    static HashSet<Integer> set;
    
    public int solution(String numbers) {
        len = numbers.length();
        check = new boolean[len];
        set = new HashSet<>();
        
        for (int i = 1; i <= len; i++) {
            permutation(0, "", i, numbers);
        }
        
        return set.size();
    }
    
    public static void permutation(int depth, String num, int cnt, String numbers) {
        if (depth == cnt) {
            int n = Integer.parseInt(num);
            if (n == 2 || isPrime(n)) {
                set.add(n);
            }
        } else {
            for (int cur = 0; cur < len; cur++) {
                if (check[cur]) continue;
                
                check[cur] = true;
                permutation(depth + 1, num + numbers.charAt(cur), cnt, numbers);
                check[cur] = false;
            }
        }
    }
    
    public static boolean isPrime(int n) {
        if (n == 0 || n == 1) return false;
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        
        return true;
    }
}
