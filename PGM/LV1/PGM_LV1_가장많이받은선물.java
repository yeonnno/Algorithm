import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int len = friends.length;
        int[][] giftRecord = new int[len][len];
        int[][] result = new int[len][4]; // 준선물, 받은선물, 선물지수, 다음달
        HashMap<String, Integer> map = new HashMap<>();
        
        // 배열 인덱스 저장
        for (int i = 0; i < len; i++) {
            map.put(friends[i], i);
        }
        
        // 이번달 주고받은 선물 기록
        for (String gift : gifts) {
            String[] str = gift.split(" ");
            giftRecord[map.get(str[0])][map.get(str[1])]++;
        }
        
        // 친구들 별 준선물, 받은선물, 선물지수 계산
        for (int i = 0; i < len; i++) {
            int giveCnt = 0;
            int receiveCnt = 0;
            
            for (int j = 0; j < len; j++) {
                giveCnt += giftRecord[i][j];
                receiveCnt += giftRecord[j][i];
            }
            
            result[i][0] = giveCnt;
            result[i][1] = receiveCnt;
            result[i][2] = giveCnt - receiveCnt;
        }
        
        // 다음달 선물 계산
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // 주고받은 기록 없거나 같은 경우
                if (giftRecord[i][j] == giftRecord[j][i]) {
                    // 선물지수 i > j
                    if (result[i][2] > result[j][2]) result[i][3]++;
                    // 선물지수 i < j
                    else if (result[i][2] < result[j][2]) result[j][3]++;
                    // 선물지수 i == j
                    else continue;
                }
                // i가 준 선물이 더 많은 경우
                else if (giftRecord[i][j] > giftRecord[j][i]) result[i][3]++;
                // j가 준 선물이 더 많은 경우
                else if (giftRecord[i][j] < giftRecord[j][i]) result[j][3]++;
            }
        }
        
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, result[i][3]);
        }
        
        return answer;
    }
}
