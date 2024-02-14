import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        A = Arrays.stream(A).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::valueOf).toArray();
        B = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::valueOf).toArray();
        
        int idxA = 0;
        int idxB = 0;
        
        while(idxA!= A.length){
            if(B[idxB] > A[idxA]){
                idxB++;
                answer++;
            }
            idxA++;
        }
        
        return answer;
    }
}