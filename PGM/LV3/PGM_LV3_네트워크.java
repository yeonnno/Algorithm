import java.util.*;

class Solution {
    static int[] parent;
    public int solution(int n, int[][] computers) {
        parent = new int[computers.length];
        for (int i = 0; i < computers.length; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = i + 1; j < computers.length; j++) {
                if (computers[i][j] != 1) continue;
                if (isSameParent(i, j)) continue;
                
                union(i, j);
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < computers.length; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
    
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) parent[y] = x;
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return true;
        else return false;
    }
}
