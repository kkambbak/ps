import java.util.*;

class Solution {
    List<String> li = new ArrayList<>();
    public int solution(String numbers) {
        int answer = 0;
        String[] numS = numbers.split("");
        int[] nums = new int[numbers.length()];
        for(int i = 0; i < numS.length; i++){
            nums[i] = Integer.parseInt(numS[i]);
        }
        makeNum("", nums, new boolean[nums.length]);
        //System.out.println(li);
        
        return (int) li.stream().distinct().filter(i->isPrime(i)).count();
    }
    
    public boolean isPrime(String n){
        int num = Integer.parseInt(n);
        if(num==1) return false;
        for(int i = 2; i <= num/2; i++){
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public void makeNum(String s, int[] nums, boolean[] visited){
        
        if(!s.equals("")){
            li.add(s);
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(s.equals("") && nums[i]==0) continue;
            visited[i] = true;
            makeNum(s+nums[i], nums, visited);
            visited[i] = false;
        }
    }
}