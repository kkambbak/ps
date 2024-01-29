import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        int day = 0;
        Stack<Integer> days = new Stack<>();
        for(int i = progresses.length-1; i >= 0; i--){
            day = (int)Math.ceil((100 - progresses[i]) / (double)speeds[i]);
            days.push(day);
        }
        while(days.size()!=0){
            int count = 1;
            int num = days.pop();
            while(days.size()!=0 && days.peek() <= num) {
                days.pop();
                count++;
            }
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}