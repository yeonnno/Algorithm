class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            String str1 = Integer.toBinaryString(arr1[i]);
            String str2 = Integer.toBinaryString(arr2[i]);
            
            while (n-str1.length() > 0) {
                str1 = "0" + str1;
            }
            
             while (n-str2.length() > 0) {
                str2 = "0" + str2;
            }
            
            for (int j = 0; j < n; j++) {
                map1[i][j] = str1.charAt(j) - '0';
                map2[i][j] = str2.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < n; i++) {
            String tmp = "";
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 1 || map2[i][j] == 1) tmp += "#";
                else tmp += " ";
            }
            answer[i] = tmp;
        }
        
        return answer;
    }
}
