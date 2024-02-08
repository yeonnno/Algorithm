class Solution {
    public int solution(String s) {
        int answer = 0;
        char beforeCh = s.charAt(0);
        
        int diff = 0, same = 1;
        for (int i = 1; i < s.length(); i++) {
            if (beforeCh == s.charAt(i)) same++;
            else diff++;
            
            if (diff == same) {
                answer++;
                diff = 0;
                same = 0;
                
                if (i + 1 < s.length()) {
                    beforeCh = s.charAt(i + 1);
                }
            }
        }
        
        if (diff != same) answer++;
        
        return answer;
    }
}
