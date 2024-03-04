import java.util.*;

class Solution {
    
    int[] arr;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }
        
        Arrays.sort(costs, (i, j)-> i[2] - j[2]);
        
        for(int i = 0; i < costs.length; i++){
            
            if(find(arr[costs[i][0]]) == find(arr[costs[i][1]])) continue;
            
            union(costs[i][0], costs[i][1]);

            answer+= costs[i][2];
        }
        
        return answer;
    }
    
    public void union(int a, int b){  
        int ax = find(a);  
        int bx = find(b);  
        if(ax!=bx){  
            if(ax < bx){  
                arr[bx] = ax;  
            }  
            else arr[ax] = bx;  
        }  
    }  
  
    public int find(int a){  
        if(a == arr[a]){  
            return a;  
        } else{  
            return arr[a] = find(arr[a]);  
        }  
    }  

}