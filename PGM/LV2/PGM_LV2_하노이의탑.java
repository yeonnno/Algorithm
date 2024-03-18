import java.util.*;

class Solution {
    static List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();
        
        backtrack(n, 1, 3, 2);
        
        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        
        return answer;
    }
    
    public static void backtrack(int n, int from, int to, int tmp) {
        if (n == 1) {
            list.add(new int[]{from, to});
        } else {
            backtrack(n - 1, from, tmp, to);
            list.add(new int[]{from, to});
            backtrack(n - 1, tmp, to, from);
        }
    }
}
