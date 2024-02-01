import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (i,j)->i[1]-j[1]);
        
        int temp = routes[0][1];
        answer++;
        for(int i = 1; i < routes.length; i++){
            if(routes[i][0] > temp) {
                temp = routes[i][1];
                answer++;
            }
        }
        
        return answer;
    }
}