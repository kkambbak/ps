class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        int[] rank = new int[]{6,6,5,4,3,2,1};
        
        int unknownCount = 0;
        int matchCount = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0) unknownCount++;
            
            else{
                for(int j = 0; j < win_nums.length; j++){
                    if(lottos[i] == win_nums[j]){
                        matchCount++;
                        break;
                    }
                }            
            }            
        }
        
        answer = new int[]{rank[matchCount+unknownCount], rank[matchCount]};
        
        return answer;
    }
}