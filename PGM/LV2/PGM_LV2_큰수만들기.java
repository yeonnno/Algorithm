class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int len = number.length() - k;
        
        int start = 0;
        for (int i = 0; i < len; i++) {
            char max = '0';
            
            for (int j = start; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    start = j + 1;
                }
                if (max == '9') break;
            }
            
            sb.append(max);
        }
        
        return sb.toString();
    }
}
