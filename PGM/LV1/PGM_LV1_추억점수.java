import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int len = photo.length;
        int[] answer = new int[len];
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        for (int i = 0; i < len; i++) {
            int sum = 0;
            
            for (String ph : photo[i]) {
                if (map.containsKey(ph)) sum += map.get(ph);
            }
            
            answer[i] = sum;
        }
        
        return answer;
    }
}
