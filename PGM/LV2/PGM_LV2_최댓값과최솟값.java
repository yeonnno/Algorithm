import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int len = sArr.length;
        int[] num = new int[len];
        for (int i = 0; i < len; i++) {
            num[i] = Integer.parseInt(sArr[i]);
        }
        
        Arrays.sort(num);
        
        return num[0] + " " + num[len - 1];
    }
}
