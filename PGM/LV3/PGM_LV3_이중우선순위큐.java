import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String oper : operations) {
            String[] op = oper.split(" ");
            int num = Integer.parseInt(op[1]);
            
            if (op[0].equals("I")) {
                min.offer(num);
                max.offer(num);
            } else {
                if (num == 1 && !max.isEmpty()) {
                    min.remove(max.poll());
                } else if (num == -1 && !min.isEmpty()) {
                    max.remove(min.poll());
                }
            }
        }
        
        if (min.isEmpty() && max.isEmpty()) return new int[] {0, 0};
        else return new int[] {max.peek(), min.peek()};
    }
}
