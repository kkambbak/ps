import java.util.*;

class Solution {
    List<Integer> li = new ArrayList<>();
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0;
        long sum2 = 0;
        int count = 600000;
        Deque<Integer> que1 = new LinkedList<>();
        for(int i: queue1) {
            sum1 += i;
            que1.add(i);
        }
        Deque<Integer> que2 = new LinkedList<>();
        for(int i: queue2){
            sum2 += i;
            que2.add(i);
        }
        
        while(!que1.isEmpty() && !que2.isEmpty()){
            if(sum1 > sum2){
                int poll = que1.poll();
                sum1 -= poll;
                sum2 += poll;
                que2.add(poll);
                answer++;
            } else if(sum1 < sum2){
                int poll = que2.poll();
                sum2 -= poll;
                sum1 += poll;
                que1.add(poll);
                answer++;
            } else {
                break;
            }
            if(answer > count)
                break;
        }
        if(que1.isEmpty() || que2.isEmpty()) return -1;
        if(answer > count) return -1;
        
        return answer;
    }
}