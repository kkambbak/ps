import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int[] arr = Arrays.stream(score)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(Integer::intValue)
            .toArray();
        
        for (int i = 0; i < score.length / m; i++){
            
            answer += arr[m*(i+1) - 1] * m;
        }
        
        return answer;
    }
}