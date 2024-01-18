class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int left;
        int right = 0;
        int sum = 0;
        answer[1] = sequence.length -1;

        for(left = 0; left < sequence.length; left++) {
            while (sum < k && right < sequence.length) {
                sum += sequence[right++];
            }

            if (sum == k) {
                if ((right - left-1) < answer[1] - answer[0]) {
                    answer[0] = left;
                    answer[1] = right - 1;
                }
            }

            sum -= sequence[left];
        }

        return answer;
    }
}