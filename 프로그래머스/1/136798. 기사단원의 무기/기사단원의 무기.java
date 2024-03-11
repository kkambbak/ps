class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            
            int count = countYaksu(i);
            if(count > limit) answer+= power;
            else answer+= count;
        }
        return answer;
    }
    
    public int countYaksu(int num){
        
        if (num==1) return 1;
        
        int count = 0;
        double sqrtNum = Math.sqrt(num);
        
        for(int i = 1; i < sqrtNum; i++){
            if(num%i == 0){
                count++;
            }
        }
        count *= 2;
        if (num % sqrtNum == 0) count++;
        return count;
    }
}