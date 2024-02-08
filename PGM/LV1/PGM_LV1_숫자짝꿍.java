import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        List<String> list = new ArrayList<>();
        String[] x = X.split("");
        String[] y = Y.split("");
        Arrays.sort(x);
        Arrays.sort(y);
        
        int left = 0, right = 0;
        while (true) {
            if (left >= X.length() || right >= Y.length()) break;
            
            int xx = Integer.parseInt(x[left]);
            int yy = Integer.parseInt(y[right]);
            
            if (xx == yy) {
                list.add(x[left]);
                left++;
                right++;
            } else if (xx > yy) {
                right++;
            } else if (xx < yy) {
                left++;
            }
        }
        
        if (list.isEmpty()) answer.append("-1");
        else if (list.get(list.size() - 1).equals("0")) answer.append("0");
        else {
            for (String str : list) {
                answer.append(str);
            }
            answer.reverse();
        }
        
        return answer.toString();
    }
}
