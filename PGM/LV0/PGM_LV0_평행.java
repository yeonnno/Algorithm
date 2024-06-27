class Solution {
    public int solution(int[][] dots) {
        
        if (calc(dots[0], dots[1]) == calc(dots[2], dots[3])) return 1;
        
        if (calc(dots[0], dots[2]) == calc(dots[1], dots[3])) return 1;
        
        if (calc(dots[0], dots[3]) == calc(dots[1], dots[2])) return 1;
        
        return 0;
    }
    
    public double calc(int[] dot1, int[] dot2) {
        return (double) (dot1[1] - dot2[1]) / (dot1[0] - dot2[0]);
    }
}
