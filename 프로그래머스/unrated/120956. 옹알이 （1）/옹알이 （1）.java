class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(String s: babbling){
            s= s.replaceAll("aya","*");
            s=s.replaceAll("ye","*");
            s=s.replaceAll("woo","*");
            s=s.replaceAll("ma","*");
            StringBuilder sb= new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                sb.append("*");
            }
            if(s.equals(sb.toString())) answer++;
        }
        return answer;
    }
}