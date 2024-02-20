class Solution {
    public int[] solution(String s) {
        
        int[] memo = new int[26];
        char[] c = s.toCharArray();
        int[] answer = new int[c.length];
    
        for(int i = 0; i < c.length; i++){
            
            int memoNum = memo[c[i]-'a'];
            
            if(memoNum == 0)
                answer[i] = -1;
            else
                answer[i] = i - memo[c[i]-'a'] + 1;
                
            memo[c[i]-'a'] = i+1;
                
        }
        return answer;
    }
}