class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][][] visited;
    
    public int solution(String dirs) {
        visited = new boolean[11][11][4];
        int answer = 0;
        int x = 5, y = 5;
        
        for (int i = 0; i < dirs.length(); i++) {
            int dir = getDir(dirs.charAt(i));
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (!isPossible(nx, ny)) continue;
            if (!visited[nx][ny][dir]) {
                answer++;
                visited[nx][ny][dir] = true;
                int rDir = (dir % 2 == 0) ? dir + 1 : dir - 1;
                visited[x][y][rDir] = true;
            }
            x = nx;
            y = ny;
        }
        
        return answer;
    }
    
    public static boolean isPossible(int nx, int ny) {
        if (nx >= 0 && nx <= 10 && ny >= 0 && ny <= 10) return true;
        else return false;
    }
    
    public static int getDir(char ch) {
        switch (ch) {
            case 'U': return 0;
            case 'D': return 1;
            case 'R': return 2;
            case 'L': return 3;
        }
        return -1;
    }
}
