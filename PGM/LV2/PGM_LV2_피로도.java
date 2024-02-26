class Solution {
    
    static int N, answer;
    static int[] selected;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        selected = new int[N];
        visited = new boolean[N];
        
        backtrack(0, k, dungeons);
        
        return answer;
    }
    
    private static void backtrack(int depth, int k, int[][] dungeons) {
        if (depth == N) {
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if (dungeons[selected[i]][0] > k) break;
                
                k -= dungeons[selected[i]][1];
                cnt++;
            }
            answer = Math.max(answer, cnt);
        } else {
            for (int cur = 0; cur < N; cur++) {
                if (visited[cur]) continue;
                
                visited[cur] = true;
                selected[depth] = cur;
                backtrack(depth + 1, k, dungeons);
                visited[cur] = false;
            }
        }
    }
}
