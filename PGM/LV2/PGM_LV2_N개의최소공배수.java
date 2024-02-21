import java.util.*;

class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            answer = LCM(answer, arr[i]);
        }
        
        return answer;
    }
    
    public static int LCM(int a, int b) {
        int A = a, B = b;
        
        while (b != 0) {
            a %= b;
            
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        return A * B / a;
    }
}
