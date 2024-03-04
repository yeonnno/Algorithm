import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> mapA = new HashMap<>();
        HashMap<Integer, Integer> mapB = new HashMap<>();
        
        for (int topp : topping) {
            mapB.put(topp, mapB.getOrDefault(topp, 0) + 1);
        }
        
        for (int i = 0; i < topping.length; i++) {
            mapA.put(topping[i], mapA.getOrDefault(topping[i], 0) + 1);
            mapB.put(topping[i], mapB.get(topping[i]) - 1);
            
            if (mapB.get(topping[i]) == 0) mapB.remove(topping[i]);
            
            if (mapA.size() == mapB.size()) answer++;
        }
        
        return answer;
    }
}
