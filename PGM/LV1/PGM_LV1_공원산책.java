class Solution {
    public int[] solution(String[] park, String[] routes) {
        int N = park.length;
        int M = park[0].length();
        int x = -1, y = -1;
        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = park[i].charAt(j);
                if (map[i][j] == 'S') {
                    x = i;
                    y = j;
                }
            }
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (String route : routes) {
            String[] str = route.split(" ");
            int dir = getDir(str[0].charAt(0));
            int cnt = Integer.parseInt(str[1]);
            boolean check = true;
            
            for (int i = 1; i <= cnt; i++) {
                int nx = x + dx[dir] * i;
                int ny = y + dy[dir] * i;
                
                if (!isPossible(N, M, nx, ny)) {
                    check = false;
                    break;
                }
                
                if (map[nx][ny] == 'X') {
                    check = false;
                    break;
                }
            }
            
            if (check) {
                x += dx[dir] * cnt;
                y += dy[dir] * cnt;
            }
        }
        
        int[] answer = {x, y};
        return answer;
    }
    
    public static int getDir(char ch) {
        switch (ch) {
            case 'N': return 0;
            case 'S': return 1;
            case 'W': return 2;
            case 'E': return 3;
        }
        return -1;
    }
    
    public static boolean isPossible(int N, int M, int nx, int ny) {
        if (nx >= 0 && nx < N && ny >= 0 && ny < M) return true;
        else return false;
    }
}
