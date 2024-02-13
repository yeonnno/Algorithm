/**
 * hashmap 써서 풀어보기
 */
class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for (int i = 0; i < targets.length; i++) {
            int sum = 0;
            boolean check = false;
            
            for (int j = 0; j < targets[i].length(); j++) {
                char targetAlpha = targets[i].charAt(j);
                int minIdx = 999;
                
                for (int k = 0; k < keymap.length; k++) {
                    for (int l = 0; l < keymap[k].length(); l++) {
                        char keymapAlpha = keymap[k].charAt(l);
                        
                        if (targetAlpha == keymapAlpha) {
                            minIdx = Math.min(minIdx, l);
                            break;
                        }
                    }
                }
                
                if (minIdx == 999) {
                    check = true;
                    break;
                } else {
                    sum += minIdx + 1;
                }
            }
            
            if (check) sum = -1;
            
            answer[i] = sum;
        }
        
        return answer;
    }
}
