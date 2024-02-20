class Solution {
    public int[] solution(int brown, int yellow) {
        int x = brown / 2;
        
        while (true) {
            int y = (brown - x * 2) / 2 + 2;
            
            if ((x - 2) * (y - 2) == yellow) return new int[]{x, y};
            
            x--;
        }
    }
}
