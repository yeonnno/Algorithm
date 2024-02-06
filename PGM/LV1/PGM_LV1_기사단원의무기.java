class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int prime = 0;
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) prime++;
                else if (i % j == 0) prime += 2;
            }
            
            if (prime > limit) answer += power;
            else answer += prime;
        }
        
        return answer;
    }
}
