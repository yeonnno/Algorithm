import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> (o1[1] - o2[1]));
        
        int answer = 1;
        int end = routes[0][1];
        
        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > end) {
                answer++;
                end = routes[i][1];
            }
        }
        
        return answer;
    }
}
