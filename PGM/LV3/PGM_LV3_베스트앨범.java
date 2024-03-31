import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> total = new HashMap<>();
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
            
            if (!music.containsKey(genres[i])) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(i, plays[i]);
                music.put(genres[i], map);
            } else {
                music.get(genres[i]).put(i, plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList<>(total.keySet());
        Collections.sort(keySet, (o1, o2) -> total.get(o2) - total.get(o1));
        
        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> musicKeySet = new ArrayList<>(map.keySet());
            
            Collections.sort(musicKeySet, (o1, o2) -> map.get(o2) - map.get(o1));
            
            res.add(musicKeySet.get(0));
            if (musicKeySet.size() > 1)
                res.add(musicKeySet.get(1));
        }
        
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        } 
        
        return answer;
    }
}
