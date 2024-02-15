class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int len = survey.length;
        int[] score = new int[8];
        
        for (int i = 0; i < len; i++) {
            if (choices[i] == 4) continue;
            else if (choices[i] < 4) {
                score[getIndex(survey[i].charAt(0))] += 4 - choices[i];
            } else {
                score[getIndex(survey[i].charAt(1))] += choices[i] - 4;
            }
        }
        
        if (score[0] >= score[1]) answer += "R";
        else answer += "T";
        
        if (score[2] >= score[3]) answer += "C";
        else answer += "F";
        
        if (score[4] >= score[5]) answer += "J";
        else answer += "M";
        
        if (score[6] >= score[7]) answer += "A";
        else answer += "N";
        
        return answer;
    }
    
    public static int getIndex(char ch) {
        switch (ch) {
            case 'R': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'F': return 3;
            case 'J': return 4;
            case 'M': return 5;
            case 'A': return 6;
            case 'N': return 7;
        }
        
        return -1;
    }
}
