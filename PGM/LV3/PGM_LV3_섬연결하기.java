import java.util.*;

class Solution {
    
    static int[] parent;
    static PriorityQueue<Node> PQ;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        PQ = new PriorityQueue<>();
        for (int[] cost : costs) {
            PQ.offer(new Node(cost[0], cost[1], cost[2]));
        }
        
        int answer = kruskal();
        return answer;
    }
    
    public static int kruskal() {
        int sum = 0;
        
        while (!PQ.isEmpty()) {
            Node node = PQ.poll();
            
            int x = find(node.s);
            int y = find(node.e);
            
            if (isSameParent(x, y)) continue;
            
            sum += node.cost;
            union(node.s, node.e);
        }
        
        return sum;
    }
    
    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
    
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x != y) parent[y] = x;
    }
    
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return true;
        else return false;
    }
    
    public static class Node implements Comparable<Node> {
        int s;
        int e;
        int cost;
        
        Node(int s, int e, int cost) {
            this.s = s;
            this.e = e;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
