import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        int[] map = new int[10000001];
        
        for(int i = 0; i < tangerine.length; i++){
            map[tangerine[i]]++; 
        }
                
        Arrays.sort(map);
        
        int sum = 0;
        int cnt = 0;
        for(int i = map.length-1; i > 0; i--){
            if(map[i] == 0) continue;
            
            sum += map[i];
            cnt++;
            if(sum >= k) break;
        }
        
        return cnt;
    }
}