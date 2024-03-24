import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        for (String word : words) {
            if (word.equals(target))
                return bfs(begin, target, words);
        }
        
        return 0;
    }
    
    public static int bfs(String begin, String target, String[] words) {
        Queue<Word> Q = new LinkedList<>();
        Q.offer(new Word(begin, 0));
        
        boolean[] visited = new boolean[words.length];
        
        while (!Q.isEmpty()) {
            Word now = Q.poll();
            
            if (target.equals(now.word))
                return now.cnt;
            
            for (int i = 0; i < words.length; i++) {
                if (visited[i]) continue;
                if (!canConvert(now.word, words[i])) continue;
                
                visited[i] = true;
                Q.offer(new Word(words[i], now.cnt + 1));
            }
        }
        
        return -1;
    }
    
    public static boolean canConvert(String s1, String s2) {
        int diff = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            
            diff++;
        }
        
        return diff == 1;
    }
    
    public static class Word {
        String word;
        int cnt;
        
        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}
