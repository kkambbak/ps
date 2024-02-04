import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        for(Integer val: map.values()){
            answer *= (val + 1); // 각 옷의 종류별로 입지 않는 경우를 포함하여 경우의 수를 계산
        }
        
        return answer - 1; // 모든 옷을 입지 않는 경우는 없으므로 -1
    }
}
