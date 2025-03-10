import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for(int i = 0; i < enemy.length; i++){
            if(que.size() < k){
                que.offer(enemy[i]);
                answer++;
                continue;
            }
            int poll = enemy[i];
            if(que.peek() < enemy[i]){
                poll = que.poll();
                que.offer(enemy[i]);
                                
            }
            if(n < poll) break;
            n -= poll;
            answer++;
        }
        
        return answer;
    }
}