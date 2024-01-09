import java.util.*;
import java.util.stream.*;

class Solution {
    
    List<int[]> li = new ArrayList<>();
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
    
        recur(0, emoticons.length, new int[users.length], users, emoticons);
        
        return getResult(users);
    }
    
    public void recur(int k, int n, int[] usages, int[][] users, int[] emoticons){
        
        //종료 조건
        if(k==n){
            li.add(usages);
            return;
        }
                
        for(int i = 1 ; i <= 4; i++){
            EmoAndUsage emo = new EmoAndUsage(i*10, emoticons[k], users);

            //더하기
            int[] sumUsage = getSum(usages, emo, users);
            //재귀호출
            recur(k+1, n, sumUsage, users, emoticons);
        }
    }
    
    public int[] getSum(int[] usages, EmoAndUsage emo, int[][] users){
        
        int[] u = Arrays.copyOf(usages, usages.length);
        
        for(int i = 0; i < users.length; i++){
            u[i] += emo.usage[i];
        }
        return u;
    }
    
    public int[] getResult(int[][] users){
        
        List<int[]> resultLi = new ArrayList<>();
        for(int[] usages: li){
            int joinCount = 0;
            int money = 0;
            for(int i = 0; i < users.length; i++){
                
                if(usages[i] >= users[i][1]){
                    joinCount++;
                } else{
                    money += usages[i];
                }
                
            }            
            resultLi.add(new int[]{joinCount, money});
        }
        
        int[] a = resultLi.stream().sorted((o1, o2) -> {
            if(o2[0] != o1[0]) {
                return o2[0] - o1[0];
            } else {
                return o2[1] - o1[1]; 
            }
        }).collect(Collectors.toList()).get(0);
        
        
        return a;
    }
}



class EmoAndUsage {
    
    int rate;
    int[] usage;
    
    public EmoAndUsage(int rate, int price, int[][] users){
        this.rate = rate;
        this.usage = new int[users.length];
        
        for(int i = 0; i < users.length; i++){
            if(users[i][0] <= rate){
                //구매
                usage[i] = (price*(100-rate)/100);
            }
        }
    }
}
/*
그리디? 이분탐색? 완탐?

임티의 할인율은 무조건 10,20,30,40 중 하나

임티플의 가입자수가 최대한 늘어나게

4의 7승, 2의 14승 16*1024 = 16000대
각각의 이모티콘이 n퍼센트일때 user가 구입할지, 구입한다면 얼마인지 구함

16000* 100 1,600,000
유저가 얼마를 썼는지 기록
*/