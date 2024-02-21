import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int ta : tangerine) {
            map.put(ta, map.getOrDefault(ta, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        for (int v : list) {
            if (k <= 0) break;
            
            answer++;
            k -= v;
        }
        
        return answer;
    }
}
/*
1, 2, 2, 3, 3, 4, 5, 5
*/
