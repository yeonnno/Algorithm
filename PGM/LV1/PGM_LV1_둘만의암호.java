class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int alpha = (int) s.charAt(i);
            int idx = 0;
            
            while (true) {
                if (idx == index) break;
                
                alpha++;
                
                if (alpha > 122) alpha = 97;
                
                char ch = (char) alpha;
                if (skip.contains(ch + "")) continue;
                else idx++;
            }
            
            answer.append((char) alpha);
        }
        
        
        return answer.toString();
    }
}
