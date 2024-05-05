class Solution {
    public int solution(int[] array) {
        int answer = -1;
        
        int[] count = new int[1000];
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        
        int maxCnt = 0;
        for (int i = 0; i < 1000; i++) {
            if (maxCnt < count[i]) {
                maxCnt = count[i];
                answer = i;
            } else if (maxCnt == count[i]) {
                answer = -1;
            }
        }
        
        return answer;
    }
}
