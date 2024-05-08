class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n; i++) {
            answer++;
            
            while (true) {
                if (answer % 3 == 0) answer++;

                String ori = "" + answer;
                String tmp = ori.replaceAll("3", "");
                if (ori.length() != tmp.length()) answer += ori.length() - tmp.length();
                
                if (answer % 3 != 0 && ori.length() == tmp.length()) break;
            }
        }
        
        return answer;
    }
}
