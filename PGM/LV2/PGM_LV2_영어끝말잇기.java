import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        boolean isFail = false;
        char lastWord = words[0].charAt(0);
        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;
        
        for (int i = 0; i < words.length; i++) {
            cnt++;
            
            if (list.contains(words[i])) {
                isFail = true;
                break;
            }
            
            int len = words[i].length();
            if (lastWord != words[i].charAt(0)) {
                isFail = true;
                break;
            }
            
            lastWord = words[i].charAt(len - 1);
            list.add(words[i]);
        }
        
        if (isFail) {
            answer[0] = (cnt - 1) % n + 1;
            answer[1] = cnt % n == 0 ? cnt / n : cnt / n + 1;
        }

        return answer;
    }
}
