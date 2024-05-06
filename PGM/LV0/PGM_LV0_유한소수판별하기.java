class Solution {
    public int solution(int a, int b) {
        int bot = b / gcd(a, b);
        
        while (bot != 1) {
            if (bot % 2 == 0) bot /= 2;
            else if (bot % 5 == 0) bot /= 5;
            else return 2;
        }
        
        return 1;
    }
    
    public int gcd(int a, int b) {
        if (b == 0) return a;
        else return gcd(b, a % b);
    }
}
