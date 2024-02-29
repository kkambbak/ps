import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] left = new int[10001];
        int[] right = new int[10001];
        
        int rCnt = 0;
        int lCnt = 0;
        
        for(int i: topping) right[i]++;
        for(int i: right){
            if(i!=0) rCnt++;
        }
        for(int i: topping){
            right[i]--;
            if(right[i]==0) rCnt--;
            
            if(left[i]==0) lCnt++;
            left[i]++;
            if(rCnt==lCnt) answer++;
        }
        
        return answer;
    }
}