class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for(int i = 0; i < numbers.length; i++){
            long num = numbers[i] + 1;
            answer[i] = (numbers[i] ^ num) >> 2;
            answer[i] += num;
        }
        
        return answer;
    }
}