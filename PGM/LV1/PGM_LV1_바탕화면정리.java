class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 99, minY = 99, maxX = -1, maxY = -1;
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    minX = Math.min(minX, i);
                    minY = Math.min(minY, j);
                    maxX = Math.max(maxX, i);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        
        int[] answer = {minX, minY, maxX+1, maxY+1};
        
        return answer;
    }
}
