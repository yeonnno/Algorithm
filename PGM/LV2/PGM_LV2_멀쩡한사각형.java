class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        
        int gcd = GCD(w, h);
        
        answer = (w / gcd + h / gcd - 1) * gcd;
        
        return (long) w * h - answer;
    }
    
    public static int GCD(int a, int b) {
        if (b == 0) return a;
        else return GCD(b, a%b);
    }
}
