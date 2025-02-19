import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int count = 1; 

        for (int num : order) {
            while (count <= num) {
                stack.push(count);
                count++;
            }
            if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                answer++;
            } else {
                break;
            }
        }
        return answer;
    }
}