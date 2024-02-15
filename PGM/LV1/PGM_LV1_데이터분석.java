import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] d : data) {
            if (d[getIdx(ext)] < val_ext) {
                list.add(d);
            }
        }
        
        int idx = getIdx(sort_by);
        Collections.sort(list, (o1, o2) -> o1[idx] - o2[idx]);
        
        int[][] answer = new int[list.size()][4];
        for (int i = 0; i <list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public static int getIdx(String str) {
        switch(str) {
            case "code": return 0;
            case "date": return 1;
            case "maximum": return 2;
            case "remain": return 3;
        }
        return -1;
    }
}
