class Solution {
    public int solution(int n) {
        int answer = 0;
        String binA = Integer.toBinaryString(n);
        int cntA = 0;
        for (int i = 0; i < binA.length(); i++) {
            if (binA.charAt(i) == '1') cntA++;
        }
        
        while (true) {
            n++;
            String binB = Integer.toBinaryString(n);
            int cntB = 0;
            for (int i = 0; i < binB.length(); i++) {
                if (binB.charAt(i) == '1') cntB++;
            }
            
            if (cntA == cntB) {
                answer = n;
                break;
            }
        }
        
        return answer;
    }
}
