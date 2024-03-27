import java.util.*;

class Solution {

    static boolean[] visited;
    static List<String> list;
    static boolean flag;
    static String[] answer;

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (o1, o2) -> o1[0].equals(o2[0]) ? o1[1].compareTo(o2[1]) : o1[0].compareTo(o2[0]));
        
        list = new ArrayList<>();
        list.add("ICN");
        visited = new boolean[tickets.length];
        flag = false;
        
        backtrack(0, "ICN", tickets);
        
        return answer;
    }
    
    public static void backtrack(int depth, String start, String[][] tickets) {
        if (flag) return;
        
        if (depth == tickets.length) {
            boolean check = true;
            
            for (int i = 0; i < tickets.length; i++) {
                if (visited[i]) continue;
                
                check = false;
                break;
            }
            
            if (check) {
                answer = new String[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    answer[i] = list.get(i);
                }
                flag = true;
            }
        } else {
            for (int i = 0; i < tickets.length; i++) {
                if (visited[i]) continue;
                if (!tickets[i][0].equals(start)) continue;
                
                visited[i] = true;
                list.add(tickets[i][1]);
                backtrack(depth + 1, tickets[i][1], tickets);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
