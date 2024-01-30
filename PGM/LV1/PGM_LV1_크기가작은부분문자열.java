class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        int tLen = t.length();
        int pLen = p.length();
        long numP = Long.parseLong(p);
        
        for (int i = 0; i < tLen - pLen + 1; i++) {
            long numT = Long.parseLong(t.substring(i, i + pLen));
            
            if (numT <= numP) answer++;
        }
        
        return answer;
    }
}
