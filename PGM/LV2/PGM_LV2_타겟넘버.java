class Solution {
    static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        DFS(0, 0, numbers, target);
        
        return answer;
    }
    
    public static void DFS(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) answer++;
        } else {
            DFS(depth + 1, sum + numbers[depth], numbers, target);
            DFS(depth + 1, sum - numbers[depth], numbers, target);
        }
    }
}
