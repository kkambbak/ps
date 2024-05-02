import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int cnt = 0;
        while(storey > 0){
            int r = (storey % 10);
            storey /= 10;
            if(r > 5){
                cnt += 10 - r;
                storey++;
            } else if(r<5){
                cnt += r;
            } else if (storey % 10 >= 5) {                
                cnt += 5;                
                storey++;
            } else{
                cnt += 5;
            }
        }
        
        return cnt;
    }
}