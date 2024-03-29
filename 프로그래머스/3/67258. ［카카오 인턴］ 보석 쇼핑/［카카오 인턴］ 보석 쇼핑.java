import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        Set<String> set = Arrays.stream(gems).collect(Collectors.toSet());
        int size = set.size();
        Map<String, Integer> map = new HashMap<>();
        
        int start = 0;
        int length = gems.length+1;
        
        for(int end = 0; end < gems.length; end++){
            map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
            
            while (map.get(gems[start]) > 1) {
                map.put(gems[start], map.get(gems[start]) - 1);
                start++;
            }
            
            if(map.size() == size && length > end - start){
                length = end - start;
                answer[0] = start+1;
                answer[1] = end+1;
            }
        }
        
        return answer;
    }
}