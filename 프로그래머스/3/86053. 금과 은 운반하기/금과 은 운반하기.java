import java.util.*;

class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        
        long start = 0;
        long end = 4*(long)Math.pow(10,14);
        long answer = end;
        
        long mid;
        while(end >= start){
            
            long gold = 0;
            long silver = 0;
            long canMove = 0;
            
            mid = (start+end) /2;
            for(int i = 0; i < t.length; i++){
                long moveCnt = mid/(t[i]*2);
                if(mid%(t[i]*2) >= t[i]){
                    moveCnt += 1;
                }
                gold += Math.min(g[i], moveCnt*w[i]);
                silver += Math.min(s[i], moveCnt*w[i]);
                canMove += Math.min(g[i]+s[i], moveCnt*w[i]);
            }
            
            if(gold >= a && silver >= b && canMove >= a+b){
                end = mid -1;
                answer = Math.min(mid, answer);
            }
            else{
                start = mid + 1;
            }
        }
        
        return answer;
    }
}