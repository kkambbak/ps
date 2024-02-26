class Solution {
    public int solution(String s) {
        int answer = 1001;
        for(int i = 1; i <= s.length()/2; i++){
            int c = check(s, i);
            System.out.println(c);
            answer = Math.min(answer, c);
        }
        return answer;
    }
    
    public int check(String s, int num){
        int cnt = 1;
        int l = 0;
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while(idx <= s.length()-num-num){
            String s1 = s.substring(idx,idx+num);
            String s2 = s.substring(idx+num, idx+num+num);
            if(s1.equals(s2)){
                cnt++;
                
                if(idx+num+num == s.length()){
                    sb.append(cnt);
                    sb.append(s1);
                    break;
                }
            }
            else{
                if(cnt!=1){
                    l+=1;
                    sb.append(cnt);
                }
                l+=num;
                sb.append(s1);
                cnt = 1;
                
            }
            idx+=num;
        }
        if(idx+num >= s.length()){
            sb.append(s.substring(idx, s.length()));
        }
        System.out.println(sb.toString());
        return sb.length();
    }
}