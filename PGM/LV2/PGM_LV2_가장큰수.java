import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] sArr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sArr[i] = "" + numbers[i] + numbers[i] + numbers[i];
        }
        
        Arrays.sort(sArr);
        
        if (sArr[numbers.length - 1].equals("000")) return "0";
        
        for (String s : sArr) {
            answer = s.substring(0, s.length() / 3) + answer;
        }
        
        return answer;
    }
}
