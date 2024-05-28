import java.util.*;

class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        long d2 = (long)d*d;
        
        for(int i = 0; i <= d; i+=k){
            long y2 = d2 - (long)i*i;
            
            int y = (int)(Math.sqrt(y2) / k) ;
            answer += (y+1);
        }
        return answer;
    }
}