class Solution {
    static int[][] map;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int idx = 1;
        map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = idx++;
            }
        }
        
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = rotate(x1, y1, x2, y2);
        }
        
        return answer;
    }
    
    public static int rotate(int x1, int y1, int x2, int y2) {
        int x = x1;
        int y = y1;
        int tmp = map[x][y];
        int min = map[x][y];
        int d = 0;

        while (d < 4) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= x1 && nx <= x2 && ny >= y1 && ny <= y2) {
                min = Math.min(min, map[nx][ny]);
                map[x][y] = map[nx][ny];
                x = nx;
                y = ny;
            } else {
                d++;
            }
        }
        
        map[x1][y1 + 1] = tmp;
        
        return min;
    }
}
