class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "fail";
        int len = db.length;
        
        for (int i = 0; i < len; i++) {
            if (id_pw[0].equals(db[i][0])) {
                answer = "wrong pw";
                if (id_pw[1].equals(db[i][1])) {
                    answer = "login";
                }
            }
        }
        
        return answer;
    }
}
