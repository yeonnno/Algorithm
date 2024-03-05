class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                answer[i] = numbers[i] + 1;
            } else {
                StringBuilder sb = new StringBuilder();
                String num = sb.append("0").append(Long.toBinaryString(numbers[i])).reverse().toString();
                
                long idx = 0;
                for (int j = 0; j < num.length(); j++) {
                    if (num.charAt(j) == '0') {
                        idx = j;
                        break;
                    }
                }
                
                answer[i] = numbers[i] + (long) Math.pow(2, idx) - (long) Math.pow(2, idx - 1);
            }
        }
        
        return answer;
    }
}
