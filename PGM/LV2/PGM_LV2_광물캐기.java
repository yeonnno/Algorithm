import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        List<Mine> list = new ArrayList<>();
        int totalPick = picks[0] + picks[1] + picks[2];
        
        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPick == 0) break;
            
            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5; j++) {
                if (j == minerals.length) break;
                
                dia += 1;
                if (minerals[j].equals("diamond")) {
                    iron += 5;
                    stone += 25;
                } else if (minerals[j].equals("iron")) {
                    iron += 1;
                    stone += 5;
                } else {
                    iron += 1;
                    stone += 1;
                }
            }
            
            list.add(new Mine(dia, iron, stone));
            totalPick--;
        }
        
        Collections.sort(list, (o1, o2) -> (o2.stone - o1.stone));
        
        for (Mine m : list) {
            if (picks[0] > 0) {
                answer += m.dia;
                picks[0]--;
            } else if (picks[1] > 0) {
                answer += m.iron;
                picks[1]--;
            } else if (picks[2] > 0) {
                answer += m.stone;
                picks[2]--;
            }
        }
        
        return answer;
    }
    
    public static class Mine {
        int dia;
        int iron;
        int stone;
        
        Mine(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
}
