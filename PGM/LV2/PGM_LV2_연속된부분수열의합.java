class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[0] = 0; answer[1] = sequence.length - 1;
        
        int left = 0, right = 1;
        int sum = sequence[0];
        
        while (left < right) {
            if (sum == k) {
                if (answer[1] - answer[0] > right - left - 1) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }
                sum -= sequence[left];
                left++;
            }
            else if (sum > k) {
                sum -= sequence[left];
                left++;
            } else if (sum < k && right < sequence.length) {
                sum += sequence[right];
                right++;
            } else {
                break;
            }
        }
        
        return answer;
    }
}
