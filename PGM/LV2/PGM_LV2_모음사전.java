import java.util.*;

class Solution {
    static String[] sArr;
    static List<String> list;
    public int solution(String word) {
        sArr = new String[]{"A", "E", "I", "O", "U"};
        list = new ArrayList<>();
        
        backtrack(0, "");
        
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            if (word.equals(list.get(i))) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
    
    public static void backtrack(int depth, String str) {
        list.add(str);
        
        if (depth == 5) return;
        
        for (int i = 0; i < 5; i++) {
            backtrack(depth + 1, str + sArr[i]);
        }
    }
}
