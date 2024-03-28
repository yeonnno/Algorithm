import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int Aidx = A.length - 1;
        int Bidx = B.length - 1;
        while (Aidx >= 0 && Bidx >= 0) {
            if (A[Aidx] < B[Bidx]) {
                answer++;
                Aidx--;
                Bidx--;
            } else {
                Aidx--;
            }
        }
        
        return answer;
    }
}
