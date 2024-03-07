class Solution {
    static int[] answer;
    public int[] solution(int[][] arr) {
        answer = new int[2];
        
        backtrack(0, 0, arr.length, arr);
        
        return answer;
    }
    
    public static void backtrack(int x, int y, int size, int[][] arr) {
        if (isSameNum(x, y, size, arr)) {
            answer[arr[x][y]]++;
            return;
        }
        
        backtrack(x, y, size / 2, arr);
        backtrack(x + size / 2, y, size / 2, arr);
        backtrack(x, y + size / 2, size / 2, arr);
        backtrack(x + size / 2, y + size / 2, size / 2, arr);
    }
    
    public static boolean isSameNum(int x, int y, int size, int[][] arr) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[x][y] != arr[i][j]) return false;
            }
        }
        return true;
    }
}
