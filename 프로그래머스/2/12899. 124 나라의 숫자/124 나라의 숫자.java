class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            int r = n % 3;
            
            if(r==0){
                sb.insert(0, "4");
                n = n/3 - 1;
            }
            else{
                sb.insert(0, r);
                n = n/3;
            }
        }
            
        return sb.toString();
    }
}