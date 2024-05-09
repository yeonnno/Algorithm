class Solution {
    public int solution(int chicken) {
        int answer = 0;
        
        while (chicken >= 10) {
            answer += chicken / 10;
            int tmp = chicken % 10;
            chicken = chicken / 10 + tmp;
        }
        
        return answer;
    }
}
