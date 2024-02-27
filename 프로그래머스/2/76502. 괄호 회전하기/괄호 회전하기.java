import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        check(s);
        System.out.println(rotate(s));
        for(int i = 0; i < s.length(); i++){
            if(check(s)) answer++;
            s = rotate(s);
        }
        return answer;
    }
    public String rotate(String s){
        return s.substring(1,s.length()) + s.charAt(0);
    }
    
    public boolean check(String s){
        String[] ss = s.split("");
        Stack<String> stack = new Stack<>();
        
        for(String s1: ss){
            if(s1.equals("(")){
                stack.push(")");
            }
            else if(s1.equals("{")){
                stack.push("}");
            }
            else if(s1.equals("[")){
                stack.push("]");
            }
            else {
                if(stack.size()==0) return false;
                String pop = stack.pop();
                if(!pop.equals(s1)){
                    return false;
                }
            }
        }
        
        return stack.size()==0 ? true : false;
    }
}