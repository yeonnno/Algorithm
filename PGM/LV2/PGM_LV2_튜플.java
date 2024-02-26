import java.util.*;

class Solution {
    public int[] solution(String s) {
        String[] sArr = s.split("\\{\\{|\\}\\}|\\},\\{|,");
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < sArr.length; i++) {
            int key = Integer.parseInt(sArr[i]);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int[] answer = new int[map.size()];
        
        int idx = 0;
        for (int key : keySet) {
            answer[idx++] = key;
        }
        
        return answer;
    }
}
