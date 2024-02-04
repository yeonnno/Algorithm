class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int bottle = n;
        
        while (bottle >= a) {
            int x = bottle / a;
            int y = bottle % a;
            
            answer += x * b;
            bottle = x * b + y;
        }
        
        return answer;
    }
}
