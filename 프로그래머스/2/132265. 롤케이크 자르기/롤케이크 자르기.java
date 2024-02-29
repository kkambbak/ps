import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Set<Integer> set1 = Arrays.stream(topping, 0, 1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(topping, 1, topping.length).boxed().collect(Collectors.toSet());
        
        if(set1.size() == set2.size()) answer++;
        
        for(int i = 1; i < topping.length; i++){
            set1.add(topping[i]);
            set2.remove(topping[i]);
            for(int j = i+1; j < topping.length; j++){
                if(topping[j] == topping[i]){
                    set2.add(topping[i]);
                    break;
                }
            }
            if(set1.size() == set2.size()) answer++;
        }
        
        return answer;
    }
}