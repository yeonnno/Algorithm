import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {   
        Queue<String> Q1 = new LinkedList<>();
        Queue<String> Q2 = new LinkedList<>();
        
        for (String card : cards1) Q1.add(card);
        for (String card : cards2) Q2.add(card);
        
        for (String go : goal) {
            if (!Q1.isEmpty() && go.equals(Q1.peek())) Q1.poll();
            else if (!Q2.isEmpty() && go.equals(Q2.peek())) Q2.poll();
            else return "No";
        }
        
        return "Yes";
    }
}
