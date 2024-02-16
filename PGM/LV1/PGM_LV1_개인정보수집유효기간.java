import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] arr = today.split("\\.");
        int[] tod = new int[3];
        for (int i = 0; i < 3; i++) {
            tod[i] = Integer.parseInt(arr[i]);
        }
        int todayInt = tod[0] * 10000 + tod[1] * 100 + tod[2];
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] ter = term.split(" ");
            map.put(ter[0], Integer.parseInt(ter[1]));
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            String[] pri = privacies[i].split("\\.| ");
            int yy = Integer.parseInt(pri[0]);
            int mm = Integer.parseInt(pri[1]);
            int dd = Integer.parseInt(pri[2]);
            
            int priD = dd - 1 == 0 ? 28 : dd - 1;
            int priM = dd - 1 == 0 ? mm - 1 : mm;
            int priY = (priM + map.get(pri[3]) - 1) / 12 + yy;
            priM = (priM + map.get(pri[3]) - 1) % 12 + 1;
            
            int priInt = priY * 10000 + priM * 100 + priD;

            if (priInt < todayInt) list.add(i + 1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
