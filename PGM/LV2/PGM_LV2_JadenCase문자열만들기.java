class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        boolean isBlank = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            if (ch == ' ') {
                isBlank = true;
                sb.append(ch);
            } else {
                if (isBlank) {
                    isBlank = false;
                    sb.append(Character.toUpperCase(ch));
                } else {
                    sb.append(ch);
                }
            }
        }
        
        return sb.toString();
    }
}
