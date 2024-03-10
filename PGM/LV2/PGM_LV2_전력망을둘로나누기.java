class Solution {
    static int[] parent;
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        parent = new int[n + 1];
        int[] count;
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j] = j;
            }
            
            for (int j = 0; j < n - 1; j++) {
                if (i == j) continue;
                
                int s = wires[j][0];
                int e = wires[j][1];
                
                if (isSameParent(s, e)) continue;
                
                union(s, e);
            }
            
            int v = find(1);
            count = new int[2];
            count[0]++;
            for (int j = 2; j <= n; j++) {
                if (v == find(j)) count[0]++;
                else count[1]++;
            }
            
            answer = Math.min(answer, Math.abs(count[0] - count[1]));
        }
        
        return answer;
    }
    
    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return true;
        else return false;
    }
    
    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    
    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) parent[y] = x;
    }
}
