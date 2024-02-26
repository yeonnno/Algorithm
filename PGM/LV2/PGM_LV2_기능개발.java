import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = ((100 - progresses[i]) % speeds[i] == 0) ? (100 - progresses[i]) / speeds[i] : (100 - progresses[i]) / speeds[i] + 1;
            
            if (!que.isEmpty() && que.peek() < day) {
                list.add(que.size());
                que.clear();
            }
            
            que.offer(day);
        }
        list.add(que.size());
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
