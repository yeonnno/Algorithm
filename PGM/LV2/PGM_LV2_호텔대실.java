class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[] time = new int[25*60];
        
        for (String[] book : book_time) {
            String[] tmp1 = book[0].split(":");
            int start = Integer.parseInt(tmp1[0]) * 60 + Integer.parseInt(tmp1[1]);
            
            String[] tmp2 = book[1].split(":");
            int end = Integer.parseInt(tmp2[0]) * 60 + Integer.parseInt(tmp2[1]);
            end += 10;
            
            for (int i = start; i < end; i++) {
                time[i]++;
            }
        }
        
        for (int i = 0; i < 25*60; i++) {
            if (answer < time[i]) answer = time[i];
        }
        
        return answer;
    }
}
