class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            if (storey % 10 < 5) {
                answer += storey % 10;
                storey /= 10;
            } else if (storey % 10 == 5) {
                if (storey / 10 % 10 < 5) {
                    answer += storey % 10;
                    storey /= 10;
                } else {
                    answer += storey % 10;
                    storey /= 10;
                    storey += 1;
                }
            } else {
                answer += 10 - storey % 10;
                storey /= 10;
                storey += 1;
            }
        }
        
        return answer;
    }
}
