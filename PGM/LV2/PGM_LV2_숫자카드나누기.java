import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];
        
        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }
        
        if (!divide(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }
        
        if (!divide(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }
        
        return answer;
    }
    
    public static boolean divide(int[] array, int gcd) {
        for (int arr : array) {
            if (arr % gcd == 0) return true;
        }
        return false;
    }
    
    public static int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        return a;
    }
}
