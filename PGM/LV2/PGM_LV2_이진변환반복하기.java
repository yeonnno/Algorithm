class Solution {
    public int[] solution(String s) {
        int changeCnt = 0;
        int zeroCnt = 0;
        
        while (true) {
            int beforeLen = s.length();
            
            if (beforeLen == 1) break;
            
            s = s.replace("0", "");
            int afterLen = s.length();
            
            changeCnt++;
            zeroCnt += beforeLen - afterLen;
            
            s = Integer.toBinaryString(afterLen);
        }
        
        return new int[]{changeCnt, zeroCnt};
    }
}
