class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int c = 0;
        String[] poly = polynomial.split(" ");
        for (String p : poly) {
            if (p.contains("x")) {
                if (p.equals("x")) x += 1;
                else x += Integer.parseInt(p.substring(0, p.length() - 1));
            } else if (!p.equals("+")) c += Integer.parseInt(p);
        }
        
        String strX = "";
        String strC = "";
        String res = "";
        if (x > 0) {
            if (x == 1) strX += "x";
            else strX = x + "x";
        }
        if (c > 0) {
            strC += c;
        }
        
        if (x > 0) {
            if (c > 0) res = strX + " + " + strC;
            else res = strX;
        } else {
            res = strC;
        }
        return res;
    }
}
