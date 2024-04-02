import java.util.*;

class Solution {
    
    String[][] relations;
    Set<String> candidates;
    
    public int solution(String[][] relation) {
        int answer = 0;
        
        relations = relation;
        candidates = new HashSet<>();
        
        for(int i = 1; i < relation[0].length; i++){
            boolean[] arr = new boolean[relation[0].length];
            combi(arr,0,0,i);
        }
        answer = candidates.size();
        return answer==0 ? 1 : answer;
    }
    
    public void combi(boolean[] visited, int idx, int cnt, int r){
        if(cnt==r){
            String key = "";
            for(int i =0; i < visited.length; i++){
                if(visited[i]) key+= i;
            }
            
            if(isMinimal(visited) && isUnique(visited)) candidates.add(key);
        }
        
        if(idx==visited.length) return;
        
        visited[idx] = true;
        combi(visited, idx+1, cnt+1, r);
        
        visited[idx] = false;
        combi(visited, idx+1, cnt, r);
    }
    
    public boolean isMinimal(boolean[] arr){
        
        boolean check = true;
        for(String s : candidates){
            if(!check(s, arr)) check = false;
        }
        return check ? true: false;
    }
    
    public boolean check(String s, boolean[] arr){
        // 최소성을 만족하지 못하면 false를 반환
        for(int i = 0; i < s.length(); i++){
            if(!arr[s.charAt(i) - '0']) return true;
        }
        return false;
    }
    
    public boolean isUnique(boolean[] attArr){
        
        Set<String> set = new HashSet<>();
        
        for(String[] tuple: relations){
            String key = "";                        
            for(int i = 0; i < attArr.length; i++){
                if(attArr[i]) key+= tuple[i];
            }
            if(set.contains(key)) return false;
            else set.add(key);
        }
        return true;
    }
}