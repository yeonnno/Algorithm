import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int len = want.length;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(want[i], i);
        }
        
        for (int i = 0; i < discount.length - 9; i++) {
            int[] count = new int[len];
            boolean isSuccess = true;
            
            for (int j = 0; j < 10; j++) {
                if (map.containsKey(discount[i + j])) {
                    count[map.get(discount[i + j])]++;
                }
            }
            
            for (int j = 0; j < len; j++) {
                if (number[j] != count[j]) {
                    isSuccess = false;
                    break;
                }
            }
            
            if (isSuccess) answer++;
        }
        
        return answer;
    }
}
