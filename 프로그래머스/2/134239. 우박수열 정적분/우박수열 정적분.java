import java.util.*;

class Solution {
    ArrayList<Integer> li;
    int count;
    double[] spaces;
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        getCollatz(k);
        spaces = new double[count+1];
        
        for(int i = 0; i < count; i++){
            //넓이구하기
            int a = li.get(i);
            int b = li.get(i+1);
            int abs = Math.abs(a-b);
            spaces[i] = ((double) abs / 2) + Math.min(a,b);
        }
        
        int idx = 0;
        for(int[] range: ranges){
            answer[idx] = integral(range[0], count + range[1]);
            idx++;
        }
        
        return answer;
    }
    
    public void getCollatz(int k){
        
        li = new ArrayList<>();
        li.add(k);
        while(k != 1){
            if(k % 2 == 0) k /= 2;
            else k = k*3 + 1;
            count++;
            li.add(k);
        }
    }
    
    public double integral(int a, int b){
        
        if(a > count || b > count || a > b) return -1;
        
        double s = 0;
        
        for(int i = a; i < b; i++){
            s += spaces[i];
        }
        
        return s;
    }
}