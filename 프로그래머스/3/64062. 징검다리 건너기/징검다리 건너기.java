import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int end = Arrays.stream(stones).max().getAsInt();
        int start = 1;
        
        while(end - start > 1){
            int mid = (start + end) / 2;
            
            if(cross(stones, k, mid)){
                start = mid;
            } else{
                end = mid;
            }
        }
        
        return end;
    }
    
    public boolean cross(int[] stones, int k, int n){
        
        int[] copy = new int[stones.length];
        for(int i = 0; i < stones.length; i++){
            if(stones[i] - n > 0){
                copy[i] = stones[i] - n;
            }
        }
        
        int cnt = 0;
        for(int i = 0; i < stones.length; i++){
            if(copy[i] == 0){
                cnt++;
                if(cnt >= k){
                    return false;
                }
            } else{
                cnt = 0;
            }
        }
        
        return true;
    }
}