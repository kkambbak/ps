import java.util.*;

class Solution {
    String[] people = new String[]{"A", "C", "F", "J", "M", "N", "R", "T"};
    String[] datas;
    List<String> list;
    public int solution(int n, String[] data) {
        int answer = 0;
        datas = data;
        list = new ArrayList<>();
        makeList(0, "", new boolean[8]);
        
        //System.out.println(list.size());

        for(String s: list){
            if(check(s, data)) answer++;
        }
        
        return answer;
    }
    public boolean check(String s, String[] data){
        
        for(String d: data) {
            if(!checkData(s, d)) return false;
        }
        
        return true;
    }
    
    public boolean checkData(String s, String d){
        String p1 = Character.toString(d.charAt(0));
        String p2 = Character.toString(d.charAt(2));
        int dist = Integer.valueOf(d.charAt(4)-'0');
        int p1s = s.indexOf(p1);
        int p2s = s.indexOf(p2);
        
        // System.out.println("p1s: "+ p1s);
        // System.out.println("p2s: "+ p2s);
        // System.out.println("dist: "+ dist);
        
        if(d.charAt(3) == '='){
            if (Math.abs(p1s-p2s) == dist+1)
                return true;
        } else if(d.charAt(3) == '>'){
            if (Math.abs(p1s-p2s) > dist+1)
                return true;
        } else{
            if(Math.abs(p1s-p2s) < dist+1)
                return true;
        }
        
        return false;
    }
    
    public void makeList(int n, String s, boolean[] visited){
        
        if(n==8){
            list.add(s);
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                sb.append(people[i]);
                visited[i] = true;
                makeList(n+1, sb.toString(), visited);
                visited[i] = false;
                sb.deleteCharAt(n);
            }
        }
    }
}
/*
전체 경우의 수: 8! = 40320

40320 * 100 = 4032000
*/