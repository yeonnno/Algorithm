import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int len = elements.length;
        
        HashSet<Integer> set = new HashSet<>();
        int total = 0;
        for (int el : elements) {
            set.add(el);
            total += el;
        }
        set.add(total);
        
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k < i; k++) {
                    if (j + k >= len) {
                        sum += elements[j + k - len];
                    } else {
                        sum += elements[j + k];
                    }
                }
                set.add(sum);
            }
        }
        
        return set.size();
    }
}
