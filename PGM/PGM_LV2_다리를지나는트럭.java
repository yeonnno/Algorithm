import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        Deque<Integer> truck_weight = new ArrayDeque<>();
        for (int i = 0; i < truck_weights.length; i++) {
            truck_weight.add(truck_weights[i]);
        }
        
        int w = 0;
        while (!bridge.isEmpty()) {
            answer++;
            int temp = bridge.poll();
            w -= temp;
            
            if (!truck_weight.isEmpty()) {
                int temp2 = truck_weight.poll();
                if (w + temp2 <= weight) {
                    w += temp2;
                    bridge.add(temp2);
                } else {
                    truck_weight.addFirst(temp2);
                    bridge.add(0);
                }
            }
        }
        
        return answer;
    }
}
