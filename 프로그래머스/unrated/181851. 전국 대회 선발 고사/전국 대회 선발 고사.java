import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<int[]> li = new ArrayList<>();
        
        for(int i = 0; i < rank.length; i++){
            if(attendance[i]){
                li.add(new int[]{rank[i], i});
            }
        }
        List<int[]> sortedList = li.stream().sorted((o1,o2)->o1[0] - o2[0]).collect(Collectors.toList());
        
        return sortedList.get(0)[1] * 10000 + sortedList.get(1)[1] * 100 + sortedList.get(2)[1];
    
    }
}