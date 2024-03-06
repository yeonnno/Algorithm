import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }
        
        Deque<Integer> truck = new ArrayDeque<>();
        for (int truck_weight : truck_weights) {
            truck.offer(truck_weight);
        }
        
        int w = 0; // 현재 다리 위의 무게
        while (!bridge.isEmpty()) {
            answer++;
            
            int tmp = bridge.poll();
            w -= tmp; // 현재 다리 위 무게 - 건넌 트럭 무게
            
            if (!truck.isEmpty()) {
                int tmp2 = truck.poll();
                
                // 다리 위로 올라갈 수 있는 트럭인지
                if (w + tmp2 <= weight) {
                    bridge.offer(tmp2);
                    w += tmp2;
                } else {
                    truck.offerFirst(tmp2);
                    bridge.offer(0);
                }
            }
        }
        
        return answer;
    }
}
