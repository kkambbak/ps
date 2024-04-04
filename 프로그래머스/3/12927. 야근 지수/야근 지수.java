import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i: works){
            pq.add(i);
        }
        
        for(int i = 0; i < n; i++){
            pq.add(pq.poll()-1);
        }
        
        for(int i = 0; i < works.length; i++){
            int poll = pq.poll();
            if(poll < 0) return 0;
            answer += poll*poll;
        }        
        return answer;
    }
}