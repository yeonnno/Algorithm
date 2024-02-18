import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < attacks.length; i++) {
            map.put(attacks[i][0], attacks[i][1]);
        }
        
        boolean isDead = false;
        int success = 0;
        int T = attacks[attacks.length - 1][0];
        for (int i = 1; i <= T; i++) {
            if (map.containsKey(i)) {
                success = 0;
                answer -= map.get(i);
                
                if (answer <= 0) {
                    isDead = true;
                    break;
                }
            } else {
                if (answer == health) continue;
                
                answer += bandage[1];
                if (answer >= health) answer = health;
                success++;
                
                if (success == bandage[0]) {
                    answer += bandage[2];
                    success = 0;
                }
            }
        }
        
        return isDead ? -1 : answer;
    }
}
