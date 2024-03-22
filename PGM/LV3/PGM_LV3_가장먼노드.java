import java.util.*;

class Solution {
    
    static final int INF = 999999999;
    static ArrayList<Integer>[] adj;
    static int[] dist;
    static boolean[] visited;
    
    public int solution(int n, int[][] edge) {        
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        
        dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;
        
        visited = new boolean[n + 1];
        
        dijkstra();
        
        int max = -1;
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (max < dist[i]) {
                max = dist[i];
                answer = 1;
            } else if (max == dist[i]) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public static void dijkstra() {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        
        while (!Q.isEmpty()) {
            int now = Q.poll();
            
            if (visited[now]) continue;
            
            visited[now] = true;
            
            for (int next : adj[now]) {
                if (dist[next] > dist[now] + 1) {
                    dist[next] = dist[now] + 1;
                    Q.offer(next);
                }
            }
        }
    }
}
