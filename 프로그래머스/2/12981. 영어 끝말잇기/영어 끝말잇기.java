import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        Set<String> set = new HashSet();
        set.add(words[0]);
        int idx = 0;
        
        for(int i = 1; i<words.length; i++){
            
            char last = words[i-1].charAt(words[i-1].length()-1);
            char first = words[i].charAt(0);
            if(set.contains(words[i])){
                idx = i;
                break;
            }
            else if(first!=last){
                idx = i;
                break;
            }
            set.add(words[i]);
            
        }
        
        if(idx==0) return new int[]{0,0};
        
        return new int[]{idx%n+1, (int)Math.ceil((double)(idx+1)/n) };
    }
}