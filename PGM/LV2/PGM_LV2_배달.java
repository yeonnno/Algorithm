import java.util.*;

class Solution {
    static final int INF = 999999999;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] visited;
    public int solution(int N, int[][] road, int K) {
        adj = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] r : road) {
            adj[r[0]].add(new Node(r[1], r[2]));
            adj[r[1]].add(new Node(r[0], r[2]));
        }
        
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        visited = new boolean[N + 1];
        
        dijkstra();

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) answer++;
        }
        
        return answer;
    }
    
    public static void dijkstra() {
        PriorityQueue<Node> PQ = new PriorityQueue<>();
        PQ.offer(new Node(1, 0));
        
        while (!PQ.isEmpty()) {
            Node now = PQ.poll();
            
            if (visited[now.e]) continue;
            
            visited[now.e] = true;
            
            for (Node next : adj[now.e]) {
                if (dist[next.e] > dist[now.e] + next.cost) {
                    dist[next.e] = dist[now.e] + next.cost;
                    PQ.offer(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
    
    public static class Node implements Comparable<Node> {
        int e;
        int cost;
        
        Node(int e, int cost) {
            this.e = e;
            this.cost = cost;
        }
        
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
