import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        double[] fail = new double[N];
        
        Arrays.sort(stages);
        int people = 0;
        for(int i = 0; i < N; i++){
            
            int count = 0;
            
            for(int j = people; j < stages.length; j++){
                if(stages[j]==i+1){
                    count++;
                }
            }
            if(stages.length-people == 0){
                fail[i] = 0;
            } else{
                fail[i] = (double)count/(stages.length-people);
            }
            
            people += count;
            
        }
        
        List<Fail> li = new ArrayList<>();
        for(int i = 0; i < N; i++){
            li.add(new Fail(fail[i], i+1));
        }
        
        answer = li.stream()
            .sorted((i1,i2)->Double.compare(i2.fail, i1.fail))
            .mapToInt(i->i.idx)
            .toArray();
        return answer;
    }
}

class Fail{
    double fail;
    int idx;
    public Fail(double fail, int idx){
        this.fail = fail;
        this.idx = idx;
    }
}