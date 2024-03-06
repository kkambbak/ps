import java.util.*;

class Solution {
    
    public int solution(String dirs) {
        
        int answer = 0;
        
        char[] dir = dirs.toCharArray();
        
        int x = 0;
        int y = 0;
        int nx = 0;
        int ny = 0;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(char c : dir){
            if(c =='U'){
                if(y+1 > 5) continue;
                ny=y+1;
            } else if(c =='D'){
                if(y-1 < -5) continue;
                ny=y-1;
            } else if(c =='R'){
                if(x+1 > 5) continue;
                nx=x+1;
            } else{
                if(x-1 < -5) continue;
                nx=x-1;
            }
            
            String s1 = ny+""+nx+""+y+""+x;
            String s2 = y+""+x+""+ny+""+nx;
            
            if(!map.containsKey(s1) && !map.containsKey(s2))
                answer++;
            
            map.put(s1, 1);
            map.put(s2, 1);
            y = ny;
            x = nx;
        }
        return answer;
    }
}