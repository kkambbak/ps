import java.util.*;

class Solution {
    
    public String solution(String p) {
        String answer = "";
        
        return answer = recur(p);
    }
    
    public String recur(String p){
        //1
        if(p.equals("")) return "";

        //2 u v 분리
        String[] uv = splitUV(p);
        
        //3 check
        boolean b = check(uv[0]);
        if(b) {
            return uv[0] + recur(uv[1]);
        }
        //4
        else{
            String newS = "(";
            newS = newS.concat(recur(uv[1]));
            newS = newS.concat(")");
            String r = reverse(uv[0].substring(1,uv[0].length()-1));
            newS = newS.concat(r);
            return newS;
        }
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i)=='(') sb.append(')');
            else sb.append('(');
        }
        return sb.toString();
    }
    
    public String[] splitUV(String w){
        int countL = 0;
        int countR = 0;
        for(int i = 0; i < w.length(); i++){
            if(w.charAt(i)=='(') countL++;
            else countR++;
            
            if(countL == countR) break;
                            
        }
        String u = w.substring(0,countL+countR);
        String v = w.substring(countL+countR, w.length());
        return new String[]{u,v};
    }
    
    public boolean check(String u){
        
        if(u.charAt(0)==')') return false;

        Stack<Character> stack = new Stack<>();        
        for(int i = 0; i < u.length(); i++){
            if(u.charAt(i) == '(') stack.add('(');
            else{
                if(stack.size() == 0) return false;
                if(stack.peek() == '('){
                    stack.pop();
                }
            }
        }
        return true;
    }
}