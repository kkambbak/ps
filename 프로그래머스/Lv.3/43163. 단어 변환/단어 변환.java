import java.util.*;

class Solution {
    
    public int solution(String begin, String target, String[] words) {
        
        List<Integer> li = new ArrayList<>();
        if(checkWord(begin,target) == 1) return 1;
        for(int i = 0; i < words.length; i++){
            if(checkWord(begin, words[i]) == 1){
                int num = bfs(words,target,i);
                li.add(num);
            }
        }
        
        return li.size()==0 ? 0 : li.stream().min(Integer::compare).get();
    }
    
    public int bfs(String[] words, String target, int start){
        
        boolean[] visited = new boolean[words.length];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start, 1});
        visited[start] = true;
        while(!que.isEmpty()){
            int[] poll = que.poll();
            visited[poll[0]] = true;
            for(int i = 0; i < words.length; i++){
                int nx = i;
                
                if(nx < 0 || nx >= words.length) continue;
                if(visited[nx]) continue;

                int check = checkWord(words[poll[0]], words[nx]);
                
                if(check == 1) {
                    if(words[nx].equals(target)) return poll[1]+1;
                    que.add(new int[]{nx, poll[1]+1});
                    
                }
                System.out.println(poll[1]);
            }
        }
        return 0;
    }
    
    public int checkWord(String word, String target){
        
        int count = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i)!=(target.charAt(i))) count++;
        }
        return count==1 ? 1 : 0;
    }
}